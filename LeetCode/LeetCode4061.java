public class LeetCode4061 {
    public int minQueenMoves(int[] s, int[] t) {
        if (s[0] == t[0] && s[1] == t[1]) {
            return 0;
        } else if (s[0] == t[0] || s[1] == t[1] || (Math.abs(s[0] - t[0]) == Math.abs(s[1] - t[1]))) {
            return 1;
        } else {
            return 2;
        }
    }
}
