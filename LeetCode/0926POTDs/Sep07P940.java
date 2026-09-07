import java.util.Arrays;

public class Sep07P940 {
    public static int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            int idx = ch - 'a';

            dp[i] = (dp[i - 1] * 2) % MOD;

            if (lastSeen[idx] != -1) {
                int lastPos = lastSeen[idx];
                dp[i] = (dp[i] - dp[lastPos - 1] + MOD) % MOD;
            }

            lastSeen[idx] = i;
        }

        return (dp[n] - 1 + MOD) % MOD;
    }

    public static void main(String[] args) {
        String s = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(distinctSubseqII(s));
    }
}
