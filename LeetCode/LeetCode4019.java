public class LeetCode4019 {
    public static int elevatorRequests(int n, int[] requests) {
        int curr = 0;
        int res = 0;

        for (int i : requests) {
            if (curr != i) {
                res += Math.abs(i - curr);
                curr = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(elevatorRequests(3, new int[] { 2,0,0 }));
    }
}
