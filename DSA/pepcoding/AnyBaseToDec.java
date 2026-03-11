public class AnyBaseToDec {
    public static void main(String[] args) {
        int num = 492;
        int b = 8;

        System.out.println(convert(num, b));
    }

    private static int convert(int num, int b) {
        // int div = num;
        int rem = 1;
        int newNum = 0;
        int count = 1;

        while (num > 0) {
            rem = num % 10;
            num /= 10;

            // newNum += (rem * (int) Math.pow(b, count));
            // count++;

            newNum += rem * count;
            count = count * b;
        }
        return newNum;
    }
}
