package DSA.pepcoding.Stack;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String s = "3+50/2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        s = s.strip();
        int num = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (c >= 48 && c <= 57)  {
                num = num * 10 + (c - '0');
            }
            if ((c == 42 || c == 43 || c == 45 || c == 47)) {
                nums.push(num);
                num = 0;
                while (!opr.isEmpty() && precedence(opr.peek()) >= precedence(c)) {
                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.push(c);
            }
        }
        nums.push(num);

        while (!opr.isEmpty()) {
            char op = opr.pop();
            int n2 = nums.pop();
            int n1 = nums.pop();
            nums.push(performOps(n1, n2, op));
        }

        return nums.peek();
    }

    private static int precedence(char op) {
        if (op == 43 || op == 45)
            return 1;
        if (op == 42 || op == 47)
            return 2;
        return 0;
    }

    private static int performOps(int n1, int n2, char operator) {
        return switch (operator) {
            case 43 -> n1 + n2;
            case 45 -> n1 - n2;
            case 42 -> n1 * n2;
            case 47 -> n1 / n2;
            default -> 0;
        };
    }
}
