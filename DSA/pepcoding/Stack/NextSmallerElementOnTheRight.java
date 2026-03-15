import java.util.Stack;

public class NextSmallerElementOnTheRight {
    public static void main(String[] args) {
        int[] nums = {2,5,9,3,1,12,6,8,7};
        int[] res = nSETRArray(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] nSETRArray(int[] nums)  {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[nums.length];
        
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            // pop + ans -> push
            while(st.size() > 0 && nums[i] < nums[st.peek()])  {
                int pos = st.peek();
                arr[pos] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0)    {
            int pos = st.peek();
                arr[pos] = -1;
                st.pop();
        }
        return arr;
    }
}
