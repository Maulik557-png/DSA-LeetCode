public class LeetCode4000 {
    public static int largestInteger(int n, int s) {
        if (s == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        if (n * 9 < s) {
            return -1;
        }

        int c = 0;
        while (s > 0) {
            if (s >= 9) {
                sb.append(9);
                s -= 9;
            } else {
                sb.append(s);
                s = 0;
            }
            c++;
        }

        while (c < n) {
            sb.append(0);
            c++;
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(largestInteger(2, 9));
    }
}
