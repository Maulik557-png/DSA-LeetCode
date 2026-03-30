package LeetCode;

import java.util.Stack;

public class LeetCode150Alt {

    public static void main(String[] args) {
        String[] token = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(token));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int n2 = nums.pop();
                int n1 = nums.pop();
                int res = performOps(n1, n2, token);
                nums.push(res);
            } else {
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.pop();
    }

    private static int performOps(int n1, int n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return 0;
        }
    }
}
