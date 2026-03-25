import java.util.Scanner;

public class DigitOfNumber {

    private static void digits(int num)   {

        if (num == 0)    System.out.println(1);

        int temp = num;

        int digitsCount = 0;
        temp = Math.abs(temp);

        while(temp > 0)    {
            temp = temp / 10;
            digitsCount++;
        }

        int div = (int) Math.pow(10, digitsCount - 1);

        while(div != 0) {
            int digit = num / div;
            System.out.println(digit);
            
            num = num % div;
            div = div / 10;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        digits(num);
        
        sc.close();
    }
}
