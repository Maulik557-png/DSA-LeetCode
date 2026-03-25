import java.util.Scanner;

public class CountDigits {

    /* 
    * Always works best
    * Time complexity: O (log n)
    */ 
    public static int countDigits(long n) {
        if (n == 0) return 1;

        int count = 0;
        long num = Math.abs(n);
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    /* 
    * Most efficient till number < 10^18
    * Time complexity: O (1)
    */
    public static int countDigitsss(long n) {
        if (n == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(n))) + 1;
    }

    /* 
    * Only if performance is not critical
    * Time complexity: O (log n)
    */ 
    public static int countDigitss(long n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(countDigits(n));
        
        sc.close();
    }
}
