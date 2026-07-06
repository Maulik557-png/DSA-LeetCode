import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode394 {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();

                while (st.peek() != '[') {
                    sb.append(st.pop());
                }

                sb.reverse();
                String exp = sb.toString();

                st.pop();
                StringBuilder num = new StringBuilder();

                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.append(st.pop());
                }

                int n = Integer.parseInt(num.reverse().toString());
                StringBuilder decoded = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    decoded.append(exp);
                }

                for (char e : decoded.toString().toCharArray()) {
                    st.push(e);
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
