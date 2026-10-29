import os
import re
import sys
import datetime
import requests

USER = os.environ["LEETCODE_USERNAME"]
SESSION = os.environ["LEETCODE_SESSION"]
CSRF = os.environ["LEETCODE_CSRF"]
URL = "https://leetcode.com/graphql"

HEADERS = {
    "Content-Type": "application/json",
    "Referer": "https://leetcode.com",
    "x-csrftoken": CSRF,
    "User-Agent": "Mozilla/5.0",
}
COOKIES = {"LEETCODE_SESSION": SESSION, "csrftoken": CSRF}


def gql(query, variables=None):
    r = requests.post(URL, json={"query": query, "variables": variables or {}},
                      headers=HEADERS, cookies=COOKIES, timeout=30)
    r.raise_for_status()
    data = r.json()
    if "errors" in data:
        sys.exit(f"GraphQL error: {data['errors']}")
    return data["data"]


# ---------- class Solution { ... } -> public class <class_name> { ... } ----------

def _matching_brace(s, i):
    """Index of the '}' matching the '{' at s[i], skipping strings/chars/comments."""
    depth, n = 0, len(s)
    while i < n:
        c = s[i]
        if s.startswith("//", i):
            j = s.find("\n", i)
            i = n if j == -1 else j
            continue
        if s.startswith("/*", i):
            j = s.find("*/", i + 2)
            i = n if j == -1 else j + 2
            continue
        if s.startswith('"""', i):
            j = s.find('"""', i + 3)
            i = n if j == -1 else j + 3
            continue
        if c in "\"'":
            q = c
            i += 1
            while i < n and s[i] != q:
                i += 2 if s[i] == "\\" else 1
            i += 1
            continue
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return i
        i += 1
    raise ValueError("unbalanced braces")


def to_java_class(code, class_name):
    code = code.replace("\r\n", "\n").strip("\n")
    lines = code.split("\n")
    imports = [l.strip() for l in lines if l.startswith("import ")]
    rest = "\n".join(l for l in lines if not l.startswith("import ")).strip("\n")

    body, before, after = None, "", ""
    m = re.search(r"(?m)^[ \t]*(?:public\s+)?(?:final\s+)?class\s+Solution\b[^{]*\{", rest)
    if m:
        try:
            end = _matching_brace(rest, m.end() - 1)
            body = rest[m.end():end].strip("\n")
            before = rest[:m.start()].strip()
            after = rest[end + 1:].strip()
        except ValueError:
            body = None
    if body is None:
        # No "class Solution" (e.g. design problems): nest everything inside
        print(f"{class_name}: no class Solution found, wrapping whole code")
        body = "\n".join(("    " + l) if l.strip() else l for l in rest.split("\n"))

    parts = []
    if imports:
        parts.append("\n".join(dict.fromkeys(imports)))
    if before:
        parts.append(before)
    parts.append(f"public class {class_name} {{\n{body}\n}}")
    if after:
        parts.append(after)
    return "\n\n".join(parts) + "\n"


# 1. Today's POTD (LeetCode's day rolls over at 00:00 UTC = 5:30 AM IST)
potd = gql("""query { activeDailyCodingChallengeQuestion {
    date question { questionFrontendId titleSlug } } }""")["activeDailyCodingChallengeQuestion"]
date = datetime.date.fromisoformat(potd["date"])
slug = potd["question"]["titleSlug"]
number = potd["question"]["questionFrontendId"]

OUT_DIR = f"LeetCode/{date.strftime('%m%y')}POTDs"                # e.g. LeetCode/1026POTDs
class_name = f"{date.strftime('%b')}{date.day}P{number}"          # e.g. Oct28P100
filename = f"{class_name}.java"
path = os.path.join(OUT_DIR, filename)
if os.path.exists(path):
    print("Already committed, nothing to do.")
    sys.exit(0)

# 2. Your recent accepted submissions
recent = gql("""query($u:String!,$l:Int!){ recentAcSubmissionList(username:$u, limit:$l){
    id titleSlug lang timestamp } }""", {"u": USER, "l": 30})["recentAcSubmissionList"]

match = next((s for s in recent
              if s["titleSlug"] == slug and s["lang"].lower() == "java"), None)
if not match:
    print("POTD not solved in Java yet.")
    sys.exit(0)

# 3. Fetch the submitted code (needs auth) and wrap it in the file's class
details = gql("""query($id:Int!){ submissionDetails(submissionId:$id){ code } }""",
              {"id": int(match["id"])})["submissionDetails"]

os.makedirs(OUT_DIR, exist_ok=True)
with open(path, "w", encoding="utf-8") as f:
    f.write(to_java_class(details["code"], class_name))

# Expose the commit message to the workflow
msg = f"{date.strftime('%B')} {date.day} POTD"
with open(os.environ["GITHUB_OUTPUT"], "a") as f:
    f.write(f"msg={msg}\n")
print("Wrote", path)
