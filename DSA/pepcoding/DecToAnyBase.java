public class DecToAnyBase {
    public static void main(String[] args) {
        
        int num = 492;
        int b = 8;

        System.out.println(convert(num, b));

    }

    private static String convert(int num, int b) {

        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        int div = Math.abs(num);

        while(div > 0)   {

            int rem = div % b; 

            char digit = (char) ((rem < 10) ? ('0' + rem) : ('A' + (rem - 10)));
            sb.append(digit);

            div /= b;
        }

        if (num < 0) sb.append('-');

        return sb.reverse().toString();
    }

    // private static int convert1(int num, int b) {

    //     int rem = 1;
    //     int newNum = 0;
    //     int count = 1;

    //     while (num > 0) {
    //         rem = num % b;
    //         num /= b;

    //         newNum += rem * count;
    //         count = count * 10;
    //     }
    //     return newNum;
    // }
}
