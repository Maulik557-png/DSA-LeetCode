import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        List<Integer> list = new ArrayList<>();
        list.contains(0);

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
