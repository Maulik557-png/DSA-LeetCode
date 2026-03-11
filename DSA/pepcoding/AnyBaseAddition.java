public class AnyBaseAddition {
    public static void main(String[] args) {
        int num1 = 767;
        int num2 = 421;
        int b = 8;

        System.out.println(add(num1, num2, b));
    }

    private static long add(int num1, int num2, int b) {
        int digit1 = num1%10;
        int digit2 = num2%10;

        int carry = 0;
        int count = 1;
        
        long newNum = 0;
        int digit = b - 1;

        while (num1 > 0 || num2 > 0 || carry > 0) {
            digit1 = num1 % 10;
            digit2 = num2 % 10;
            num1 /= 10;
            num2 /= 10;

            digit = digit1 + digit2 + carry;
            carry = digit / b;
            digit = digit % b;

            // carry = (digit / b == 0) ? 0: 1; 
            // digit = (digit / b == 0) ? digit: digit % b;

            newNum += digit * count;
            count = count * 10;
        }

        return newNum;
    }
}
