public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        int num = 172;
        int b1 = 8;
        int b2 = 2;

        System.out.println(DecToAnyBase(anyBaseToDec(num, b1), b2));
    }

    private static int anyBaseToDec(int num, int b1) {
        int rem = 1;
        int newNum = 0;
        int count = 1;

        while (num > 0) {
            rem = num % 10;
            num /= 10;

            newNum += rem * count;
            count = count * b1;
        }
        return newNum;
    }

    private static int DecToAnyBase(int num, int b) {

        int rem = 1;
        int newNum = 0;
        int count = 1;

        while (num > 0) {
            rem = num % b;
            num /= b;

            newNum += rem * count;
            count = count * 10;
        }
        return newNum;
    }
}
