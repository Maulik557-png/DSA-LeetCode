import java.util.Stack;

public class LeetCode84 {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] rb = new int[n];
        int[] lb = new int[n];

        Stack<Integer> st = new Stack<>();

        // Right boundary
        st.push(n - 1);
        rb[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()])
                st.pop();
            rb[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Left boundary
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()])
                st.pop();
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
