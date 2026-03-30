package LeetCode;
import java.util.Stack;

public class LeetCode150 {

    public static void main(String[] args) {
        String[] token = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(token));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> infix = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                String infN2 = infix.pop();
                String infN1 = infix.pop();
                String infRes = "(" + infN1 + " " + token + " " + infN2 + ")";
                infix.push(infRes);
            } else {
                infix.push(token);
            }
        }
        return calculate(infix.pop());
    }

    public static int calculate(String s) {
        s = s.strip();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opr = new Stack<>();
        boolean expectNumber = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (c == '(') {
                opr.push(c);
                expectNumber = true;
                continue;
            }

            if (c == ')') {
                while (!opr.isEmpty() && opr.peek() != '(') {
                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.pop();
                expectNumber = false;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (expectNumber) {
                    int sign = 1;
                    if (c == '-') {
                        sign = -1;
                    }

                    i++;
                    while (i < s.length() && s.charAt(i) == ' ') {
                        i++;
                    }

                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    nums.push(sign * num);
                    i--;
                    expectNumber = false;
                    continue;
                }

                while (!opr.isEmpty() && opr.peek() != '(' && precedence(opr.peek()) >= precedence(c)) {
                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.push(c);
                expectNumber = true;
                continue;
            }

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                i--;
                expectNumber = false;
            }
        }

        while (opr.size() > 0) {
            char op = opr.pop();
            int n2 = nums.pop();
            int n1 = nums.pop();
            nums.push(performOps(n1, n2, op));
        }
        return nums.peek();
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }

    private static int performOps(int n1, int n2, char operator) {
        switch (operator) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            default:
                return 0;
        }
    }
}
