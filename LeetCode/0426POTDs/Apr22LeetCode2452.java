import java.util.*;

public class Apr22LeetCode2452 {
    public static void main(String[] args) {
        String[] quries = { "fvhsk", "dbwxm", "crfka", "ksrxj", "lqoud", "wbwxg", "dbwzg" };
        String[] dictionary = { "ddghl", "ratwy", "oqoud", "dbwxg" };
        System.out.println(twoEditWords(quries, dictionary));
    }

    // Better than below two approaches
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String q : queries) {
            for (String d : dictionary) {
                if (diffAtMostTwo(q, d)) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }

    private static boolean diffAtMostTwo(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2)
                    return false;
            }
        }
        return true;
    }

    // Good optimized approach same as mine
    // public static List<String> twoEditWords(String[] queries, String[] dictionary) {
    //     List<String> res = new ArrayList<>();
    //     for (String q : queries) {
    //         for (String d : dictionary) {
    //             int count = 0;
    //             for (int i = 0; i < q.length(); i++) {
    //                 if (q.charAt(i) != d.charAt(i)) {
    //                     count++;
    //                 }
    //                 if (count > 2) {
    //                     break;
    //                 }
    //             }
    //             if (count <= 2) {
    //                 res.add(q);
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }

    // First try
    // public static List<String> twoEditWords(String[] queries, String[] dictionary) {
    //     Set<String> set = new HashSet<>();
    //     List<String> que = new ArrayList<>(Arrays.asList(queries));
    //     List<String> dic = new ArrayList<>(Arrays.asList(dictionary));
    //     List<String> res = new ArrayList<>();

    //     for (int i = 0; i < dic.size(); i++) {
    //         char[] d = dic.get(i).toCharArray();
    //         int j = 0;
    //         while (j < que.size()) {
    //             if (que.get(j).equals("")) {
    //                 j++;
    //                 continue;
    //             }
    //             char[] q = que.get(j).toCharArray();
    //             int count = 0;
    //             for (int j2 = 0; j2 < q.length; j2++) {
    //                 if (q[j2] != d[j2]) {
    //                     count++;
    //                 }
    //                 if (count > 2) {
    //                     break;
    //                 }
    //             }
    //             if (count <= 2) {
    //                 set.add(que.get(j));
    //                 que.set(j, "");
    //             }
    //             j++;
    //         }
    //     }

    //     for (String s : queries) {
    //         if (set.contains(s)) {
    //             res.add(s);
    //         }
    //     }
    //     return res;
    // }
}
