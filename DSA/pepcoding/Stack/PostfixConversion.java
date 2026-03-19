import java.util.Stack;

public class PostfixConversion {
    public static void main(String[] args) {
        String s = "264*8/+3-"; 
        evaluateAndConvert(s);
    }

    public static void evaluateAndConvert(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                char op = c;
                int n2 = nums.pop();
                int n1 = nums.pop();
                int res = performOps(n1, n2, op);
                nums.push(res);
                String infN2 = infix.pop();
                String infN1 = infix.pop();
                String infRes = '(' + infN1 + op + infN2 + ')';
                infix.push(infRes);
                String preN2 = prefix.pop();
                String preN1 = prefix.pop();
                String preRes = op + preN1 + preN2;
                prefix.push(preRes);
            } else {
                nums.push(c - '0');
                infix.push(c + "");
                prefix.push(c + "");
            }
        }
        System.out.println("Prefix: " + prefix.pop());
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
