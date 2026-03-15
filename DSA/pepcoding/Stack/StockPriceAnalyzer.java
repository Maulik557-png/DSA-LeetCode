import java.util.Stack;

public class StockPriceAnalyzer {
    public static void main(String[] args) {
        int[] stockPrice = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] res = previousHighestPrice(stockPrice);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] previousHighestPrice(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] span = new int[nums.length];

        st.push(0);
        span[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // pop + ans -> push
            while (st.size() > 0 && nums[i] > nums[st.peek()])  st.pop();
            
            span[i] = (st.size() == 0) ? i + 1: i - st.peek();
            st.push(i);
        }
        return span;
    }
}
