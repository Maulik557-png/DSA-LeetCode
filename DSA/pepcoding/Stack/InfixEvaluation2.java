import java.util.Stack;

public class InfixEvaluation2 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        s = s.strip();
        int num = 0;
        boolean hasNum = false;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ')
                continue;
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                hasNum = true;
            } else if (c == '(') {
                opr.push(c);
            } else if (c == ')') {
                if (hasNum) {
                    nums.push(num);
                    num = 0;
                    hasNum = false;
                }
                while (opr.peek() != '(') {
                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.pop();
            } else {
                int j = i - 1;
                while (j >= 0 && s.charAt(j) == ' ')  j--;
                if (c == '-' && (j < 0 || s.charAt(j) == '('))  nums.push(0);

                if (hasNum) {
                    nums.push(num);
                    num = 0;
                    hasNum = false;
                }
                while (!opr.isEmpty() && opr.peek() != '(' &&
                        precedence(opr.peek()) >= precedence(c)) {

                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.push(c);
            }
        }

        if (hasNum) {
            nums.push(num);
        }
        while (!opr.isEmpty()) {
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
        return 0;
    }

    private static int performOps(int n1, int n2, char operator) {
        switch (operator) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                return 0;
        }
    }
}