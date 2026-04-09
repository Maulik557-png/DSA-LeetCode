public class LeetCode1208 {
    public static void main(String[] args) {
        String s = "";
        String t = "";
        int maxCost = 3;

        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int res = -1, window = 0, left = 0;

        for(int right = 0; right < n; right++)  {
            window += Math.abs(s.charAt(right) - t.charAt(right));

            while(window > maxCost) {
                window -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
