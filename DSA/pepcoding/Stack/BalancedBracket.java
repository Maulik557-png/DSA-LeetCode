import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        String s = "{(a + b) + [(c + d)]}";
        System.out.println(checkIfBalanced(s));
    }

    private static boolean checkIfBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isOpeningBracket(ch))  {
                st.push(ch);
            } else if(isRoundClosing(ch)) {
                if(st.size() == 0)  return false;
                else if(st.peek() != '(')   return false;
                else  st.pop();
            } else if (isCurlyClosing(ch)) {
                if(st.size() == 0)  return false;
                else if(st.peek() != '{')   return false;
                else  st.pop();
            } else if (isSqureClosing(ch)) {
                if(st.size() == 0)  return false;
                else if(st.peek() != '[')   return false;
                else  st.pop();
            }
        }
        if(st.size() == 0)  return true;
        else  return true;
    }

    private static boolean isOpeningBracket(char c)    {
        return (c == '(' || c == '{' || c == '[') ? true: false;
    }

    private static boolean isRoundClosing(char c)    {
        return (c == ')') ? true: false;
    }

    private static boolean isCurlyClosing(char c)    {
        return (c == '}') ? true: false;
    }

    private static boolean isSqureClosing(char c)    {
        return (c == ']') ? true: false;
    }
}
