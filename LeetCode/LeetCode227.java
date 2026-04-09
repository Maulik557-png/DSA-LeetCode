import java.util.Stack;

public class LeetCode227 {
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
                while (opr.size() > 0 && precedence(opr.peek()) >= precedence(c)) {
                    char op = opr.pop();
                    int n2 = nums.pop();
                    int n1 = nums.pop();
                    nums.push(performOps(n1, n2, op));
                }
                opr.push(c);
            }
        }
        nums.push(num);

        while (opr.size() > 0) {
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
        switch (operator) {
            case 43:
                return n1 + n2;
            case 45:
                return n1 - n2;
            case 42:
                return n1 * n2;
            case 47:
                return n1 / n2;
            default:
                return 0;
        }
    }
}
