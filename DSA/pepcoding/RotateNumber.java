import java.util.Scanner;

public class RotateNumber {
    private static long rotateTheNumber(long num, int k)  {
    
        long temp = num;

        int digitsCount = 0;
        boolean negative = num < 0;
        long absNum = Math.abs(num);

        if (negative) absNum *= -1;

        if (num == 0) return 0;
        if(k == 0) return num;

        while(temp > 0)    {
            temp = temp / 10;
            digitsCount++;
        }

        k = (k >= digitsCount) ? k % digitsCount: (k > 0? k: digitsCount + k);
        int multiplier = digitsCount - k;

        long div = (long) Math.pow(10, k);
        long mul = (long) Math.pow(10, multiplier);

        // If do not want to use Math.pow() then below option:
        // long div = 1;
        // for (int i = 0; i < k; i++) div *= 10;
        // long mul = 1;
        // for (int i = 0; i < digits - k; i++) mul *= 10;

        long newNum = ((absNum % div) * mul) + absNum / div;

        return newNum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int k = sc.nextInt();

        System.out.println(rotateTheNumber(num, k));
        
        sc.close();
    }
}
