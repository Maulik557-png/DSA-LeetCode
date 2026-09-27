import java.util.Stack;

public class Sep27P1190 {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[n];

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 1; i < n; i += j) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                j = -j;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
