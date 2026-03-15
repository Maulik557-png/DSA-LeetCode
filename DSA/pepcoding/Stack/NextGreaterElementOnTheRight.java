import java.util.Stack;

public class NextGreaterElementOnTheRight {
    public static void main(String[] args) {
        int[] nums = {2,5,9,3,1,12,6,8,7};
        int[] res = nGETRArray(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    // O(n^2)
    // public static int[] nGETRArray(int[] nums)  {
    //     int left = 0;
    //     int right = 0;
    //     int max = nums[0];
    //     int[] arr = new int[nums.length];

    //     while(left < nums.length)    {
    //         right = left;
    //         max = nums[left];

    //         while(right < nums.length)  {
    //             if(nums[right] > max)  {
    //                 arr[left] = nums[right];
    //                 break;
    //             } else  arr[left] = -1;
    //             right++;
    //         }
    //         left++;
    //     }
    //     return arr;
    // }

    // O(n)
    public static int[] nGETRArray(int[] nums)  {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[nums.length];
        int right = nums.length - 1;

        st.push(nums[right]);
        arr[right] = -1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            // pop -> ans -> push
            while(st.size() > 0 && nums[i] >= st.peek())  st.pop();
            arr[i] = (st.size() == 0) ? -1: st.peek();
            st.push(nums[i]);
        }
        return arr;
    }
}
