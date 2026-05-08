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

            if (st.size() == 0 && (ch == ')' || ch == ']' || ch == '}')) {
                return false;
            }

            if (ch == ')') {
                if (st.peek() == '(') {
                    st.pop();
                    continue;
                }
            } else if (ch == ']') {
                if (st.peek() == '[') {
                    st.pop();
                    continue;
                }
            } else if (ch == '}') {
                if (st.peek() == '{') {
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }

        return st.size() == 0 ? true : false;
    }
}
