// import java.util.HashMap;
// import java.util.Map;

public class Apr12LeetCode1320 {
    public static void main(String[] args) {
        String s = "HAPPY";
        System.out.println(minimumDistance(s));
    }

    private static Integer dp[][][];
    public static int minimumDistance(String word) {
        dp = new Integer[word.length()][27][27];
        return helper(word, 0, -1, -1);
    }

    private static int helper(String word, int i, int pos1, int pos2) {
        if (i == word.length())
            return 0;

        int ch = word.charAt(i) - 'A';

        if (dp[i][pos1 + 1][pos2 + 1] != null)
            return dp[i][pos1 + 1][pos2 + 1];

        int d1 = getDist(ch, pos1) + helper(word, i + 1, ch, pos2);
        int d2 = getDist(ch, pos2) + helper(word, i + 1, pos1, ch);

        return dp[i][pos1 + 1][pos2 + 1] = Math.min(d1, d2);
    }

    private static int getDist(int ch, int pos) {
        if (pos == -1)
            return 0;
        int x1 = ch / 6, x2 = pos / 6, y1 = ch % 6, y2 = pos % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Works Best
    // public static int minimumDistance(String word) {
    //     int[] dp = new int[26];
    //     int total = 0, maxSaved = 0;

    //     for (int i = 0; i < word.length() - 1; i++) {
    //         int cur = word.charAt(i) - 'A';
    //         int next = word.charAt(i + 1) - 'A';

    //         int d = dist(cur, next);
    //         total += d;

    //         for (int j = 0; j < 26; j++) {
    //             dp[cur] = Math.max(dp[cur], dp[j] + d - dist(j, next));
    //         }

    //         maxSaved = Math.max(maxSaved, dp[cur]);
    //     }

    //     return total - maxSaved;
    // }

    // private static int dist(int a, int b) {
    //     int x1 = a / 6, y1 = a % 6;
    //     int x2 = b / 6, y2 = b % 6;
    //     return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    // }

    // Failed approach
    // public static int minimumDistance(String word) {
    //     Map<Character, Integer> leftH = new HashMap<>();
    //     Map<Character, Integer> rightH = new HashMap<>();

    //     leftH.put('A', 0 + 0);
    //     leftH.put('B', 0 + 1);
    //     leftH.put('C', 0 + 2);
    //     leftH.put('G', 1 + 0);
    //     leftH.put('H', 1 + 1);
    //     leftH.put('I', 1 + 2);
    //     leftH.put('M', 2 + 0);
    //     leftH.put('N', 2 + 1);
    //     leftH.put('O', 2 + 2);
    //     leftH.put('S', 3 + 0);
    //     leftH.put('T', 3 + 1);
    //     leftH.put('U', 3 + 2);
    //     leftH.put('Y', 4 + 0);
    //     leftH.put('Z', 4 + 1);
    //     rightH.put('D', 0 + 3);
    //     rightH.put('E', 0 + 4);
    //     rightH.put('F', 0 + 5);
    //     rightH.put('J', 1 + 3);
    //     rightH.put('K', 1 + 4);
    //     rightH.put('L', 1 + 5);
    //     rightH.put('P', 2 + 3);
    //     rightH.put('Q', 2 + 4);
    //     rightH.put('R', 2 + 5);
    //     rightH.put('V', 3 + 3);
    //     rightH.put('W', 3 + 4);
    //     rightH.put('X', 3 + 5);

    //     int countL = 0;
    //     int countR = 0;

    //     for (char ch : word.toCharArray()) {
    //         if(leftH.containsKey(ch)) {
    //             countL = leftH.get(ch);
    //             break;
    //         }
    //     }

    //     for (char ch : word.toCharArray()) {
    //         if(rightH.containsKey(ch)) {
    //             countR = rightH.get(ch);
    //             break;
    //         }
    //     }

    //     int prevL = 0;
    //     int prevR = 0;
    //     int res = 0;

    //     for (char ch : word.toCharArray()) {
    //         if(leftH.containsKey(ch)) {
    //             if(countL == 1) continue;
    //             int l = leftH.get(ch);
    //             res += Math.abs(prevL - l);
    //             prevL = l;
    //         } else if(rightH.containsKey(ch)) {
    //             if(countR == 1) continue;
    //             int r = rightH.get(ch);
    //             res += Math.abs(prevR - r);
    //             prevR = r;
    //         }
    //     }
    //     return res - countL - countR;
    // }
}
