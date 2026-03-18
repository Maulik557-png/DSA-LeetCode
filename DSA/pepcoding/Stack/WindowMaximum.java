import java.util.Stack;

public class WindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 6, 2, 5, 4, 5, 1, 6 };
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);

        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[nums.length];
        int[] res = new int[nextGreater.length - k + 1];

        nextGreater[nextGreater.length - 1] = nextGreater.length;
        st.push(nums.length-1);

        for (int i = nums.length - 2; i >= 0; i--) {
            while(st.size() > 0 && nums[i] >= nums[st.peek()])    {
                st.pop();
            }
            nextGreater[i] = (st.size() == 0) ? nums.length: st.peek();
            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= nextGreater.length - k; i++) {
            if(j < i)  j = i;
            while(nextGreater[j] < i + k)   {
                j = nextGreater[j];
            }
            res[i] = nums[j];
        }
        return res;
    }
}
