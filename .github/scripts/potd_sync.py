import os
import sys
import datetime
import requests

USER = os.environ["LEETCODE_USERNAME"]
SESSION = os.environ["LEETCODE_SESSION"]
CSRF = os.environ["LEETCODE_CSRF"]
OUT_DIR = "LeetCode/1026POTDs"
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


# 1. Today's POTD (LeetCode's day rolls over at 00:00 UTC = 5:30 AM IST)
potd = gql("""query { activeDailyCodingChallengeQuestion {
    date question { questionFrontendId titleSlug } } }""")["activeDailyCodingChallengeQuestion"]
date = datetime.date.fromisoformat(potd["date"])
slug = potd["question"]["titleSlug"]
number = potd["question"]["questionFrontendId"]

filename = f"{date.strftime('%b')}{date.day}P{number}.java"   # Oct28P100.java
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

# 3. Fetch the submitted code (needs auth)
details = gql("""query($id:Int!){ submissionDetails(submissionId:$id){ code } }""",
              {"id": int(match["id"])})["submissionDetails"]

os.makedirs(OUT_DIR, exist_ok=True)
with open(path, "w", encoding="utf-8") as f:
    f.write(details["code"])

# Expose the commit message to the workflow
msg = f"{date.strftime('%B')} {date.day} POTD"
with open(os.environ["GITHUB_OUTPUT"], "a") as f:
    f.write(f"msg={msg}\n")
print("Wrote", path)
