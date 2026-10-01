import java.util.Stack;

public class Oct01P20 {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (st.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                return false;
            }

            switch (ch) {
                case ')' -> {
                    if (st.peek() == '(') {
                        st.pop();
                        continue;
                    }
                }
                case ']' -> {
                    if (st.peek() == '[') {
                        st.pop();
                        continue;
                    }
                }
                case '}' -> {
                    if (st.peek() == '{') {
                        st.pop();
                        continue;
                    }
                }
                default -> {
                }
            }
            st.push(ch);
        }
        return st.isEmpty();
    }
}
