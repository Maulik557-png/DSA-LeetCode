import java.util.Stack;

public class PrefixConversion {
    public static void main(String[] args) {
        String s = "-+2/*6483"; 
        evaluateAndConvert(s);
    }

    public static void evaluateAndConvert(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                char op = c;
                int n1 = nums.pop();
                int n2 = nums.pop();
                int res = performOps(n1, n2, op);
                nums.push(res);
                String infN1 = infix.pop();
                String infN2 = infix.pop();
                String infRes = '(' + infN1 + op + infN2 + ')';
                infix.push(infRes);
                String postN1 = postfix.pop();
                String postN2 = postfix.pop();
                String postRes = postN1 + postN2 + op;
                postfix.push(postRes);
            } else {
                nums.push(c - '0');
                infix.push(c + "");
                postfix.push(c + "");
            }
        }
        System.out.println("Postfix: " + postfix.pop());
        System.out.println("Infix: " + infix.pop());
        System.out.println("Answer: " + nums.pop());
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
