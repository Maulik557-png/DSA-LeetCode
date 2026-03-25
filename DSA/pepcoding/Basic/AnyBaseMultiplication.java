public class AnyBaseMultiplication {
    public static void main(String[] args) {
        int num1 = 234;
        int num2 = 76;
        int b = 8;

        System.out.println(mul(num1, num2, b));
    }

    // FIRST TRY, MY APPROACH.. WRONG Answer.

    // private static long mul(int num1, int num2, int b) {

    // int nod = numberOfDigits(num2);

    // int[] result = new int[nod];

    // int carry = 0;
    // int innerCount = 1;
    // int outerCount = 0;

    // while(num2 > 0) {

    // int digit2 = num2 % 10;
    // num2 /= 10;

    // while (num1 > 0 || carry > 0) {
    // int digit1 = num1 % 10;
    // num1 /= 10;

    // int digit = digit1 * digit2 + carry;
    // carry = digit / b;
    // digit = digit % b;

    // result[outerCount] += digit * innerCount;
    // innerCount = innerCount * 10;
    // }
    // outerCount++;
    // }
    // long ans = addAll(result, b);

    // return ans;
    // }

    // private static long addAll(int[] result, int b) {

    // int carry = 0;
    // int innerCount = 1;
    // int outerCount = 0;

    // long newNum = 0;

    // while (result[outerCount] > 0 || result[outerCount+1] > 0 || carry > 0 ||
    // outerCount < result.length - 1) {
    // int digit1 = result[outerCount] % 10;
    // int digit2 = result[outerCount+1] % 10;
    // result[outerCount] /= 10;
    // result[outerCount+1] /= 10;

    // int digit = digit1 + digit2 + carry;
    // carry = digit / b;
    // digit = digit % b;

    // newNum += digit * innerCount;
    // innerCount = innerCount * 10;
    // outerCount++;
    // }
    // return newNum;
    // }

    // private static int numberOfDigits(int num) {
    // int nod = 0;

    // while(num > 0) {
    // num /= 10;
    // nod++;
    // }
    // return nod;
    // }

    private static long mul(int num1, int num2, int base) {
        long result = 0;
        long placeShift = 1;

        while (num2 > 0) {
            int digit2 = num2 % 10;
            num2 /= 10;

            long partial = multiplySingle(num1, digit2, base);
            result = addBaseN(result, partial * placeShift, base);

            placeShift *= 10;
        }

        return result;
    }

    // multiply num1 by a single digit (digit2)
    private static long multiplySingle(int num1, int digit2, int base) {
        long product = 0;
        long place = 1;
        int carry = 0;

        while (num1 > 0 || carry > 0) {
            int digit1 = num1 % 10;
            num1 /= 10;

            int mul = digit1 * digit2 + carry;
            carry = mul / base;
            int digit = mul % base;

            product += digit * place;
            place *= 10;
        }

        return product;
    }

    // base-N addition (your earlier add logic)
    private static long addBaseN(long num1, long num2, int base) {
        long result = 0;
        long place = 1;
        int carry = 0;

        while (num1 > 0 || num2 > 0 || carry > 0) {
            int d1 = (int) (num1 % 10);
            int d2 = (int) (num2 % 10);
            num1 /= 10;
            num2 /= 10;

            int sum = d1 + d2 + carry;
            carry = sum / base;
            int digit = sum % base;

            result += digit * place;
            place *= 10;
        }

        return result;
    }

}
