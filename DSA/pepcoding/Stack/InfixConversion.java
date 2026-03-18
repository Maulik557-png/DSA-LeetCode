import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        String s = "a*(b-c)/d+e";
        toPrefixOrPostfix(s);
    }

    public static void toPrefixOrPostfix(String s) {
        Stack<Character> operator = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                operator.push(c);
            } else if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                postfix.push(c + "");
                prefix.push(c + "");
            } else if (c == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    char op = operator.pop();
                    String postN2 = postfix.pop();
                    String postN1 = postfix.pop();
                    String postRes = postN1 + postN2 + op;
                    postfix.push(postRes);
                    String preN2 = prefix.pop();
                    String preN1 = prefix.pop();
                    String preRes = op + preN1 + preN2;
                    prefix.push(preRes);
                }
                operator.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(c)) {
                    char op = operator.pop();
                    String postN2 = postfix.pop();
                    String postN1 = postfix.pop();
                    String postRes = postN1 + postN2 + op;
                    postfix.push(postRes);
                    String preN2 = prefix.pop();
                    String preN1 = prefix.pop();
                    String preRes = op + preN1 + preN2;
                    prefix.push(preRes);
                }
                operator.push(c);
            }
        }
        while (operator.size() > 0) {
            char op = operator.pop();
            String postN2 = postfix.pop();
            String postN1 = postfix.pop();
            String postRes = postN1 + postN2 + op;
            postfix.push(postRes);
            String preN2 = prefix.pop();
            String preN1 = prefix.pop();
            String preRes = op + preN1 + preN2;
            prefix.push(preRes);
        }
        System.out.println("Prefix: " + prefix.pop());
        System.out.println("Postfix: " + postfix.pop());
    }

    private static int precedence(char op) {
        if (op == 43 || op == 45)
            return 1;
        if (op == 42 || op == 47)
            return 2;
        return 0;
    }
}
