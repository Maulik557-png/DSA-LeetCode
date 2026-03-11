import java.util.Scanner;

public class ReverseDigitOfNumber {

    private static void digits(int num)   {

        int div = 10;

        while(num > 0) {
            int digit = num % div;
            System.out.println(digit);
            
            num = num / div;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        digits(num);
        
        sc.close();
    }
}
