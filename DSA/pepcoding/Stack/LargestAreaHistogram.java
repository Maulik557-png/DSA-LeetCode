import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] bar = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(largestArea(bar));
    }

    // public static int largestArea(int[] nums) {

    //     int[] rb = new int[nums.length]; // Next smaller element index on the right
    //     int[] lb = new int[nums.length]; // Next smaller element index on the left

    //     int maxArea = 0;

    //     Stack<Integer> st;
    //     st = new Stack<>();
    //     st.push(nums.length - 1);
    //     rb[nums.length - 1] = nums.length;

    //     for (int i = nums.length - 2; i >= 0; i--) {
    //         while (st.size() > 0 && nums[i] <= nums[st.peek()])
    //             st.pop();
    //         rb[i] = (st.size() == 0) ? nums.length : st.peek();
    //         st.push(i);
    //     }

    //     lb[nums.length - 1] = -1;
    //     st = new Stack<>();
    //     st.push(0);
    //     for (int i = 0; i < nums.length; i++) {
    //         while (st.size() > 0 && nums[i] <= nums[st.peek()])
    //             st.pop();
    //         lb[i] = (st.size() == 0) ? -1 : st.peek();
    //         st.push(i);
    //     }

    //     for (int i = 0; i < lb.length; i++) {
    //         int width = rb[i] - lb[i] - 1;
    //         maxArea = Math.max(maxArea, width * nums[i]);
    //     }

    //     return maxArea;
    // }

    public static int largestArea(int[] nums) {
        int n = nums.length;
        int[] rb = new int[n];
        int[] lb = new int[n];

        Stack<Integer> st = new Stack<>();

        // Right boundary
        st.push(n - 1);
        rb[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()])  st.pop();
            rb[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Left boundary
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()])  st.pop();
            lb[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * nums[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
