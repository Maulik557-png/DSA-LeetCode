import java.util.Scanner;

public class InverseOfNumber {

    private static int inverse(int num)  {

        int div = 10;
        int i = 0;
        int inverse = 0;

        while(num > 0) {
            i++;
            int digit = num % div;
            inverse = inverse + (i * (int) Math.pow(10, digit - 1));
            num = num / div;
        }

        return inverse;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(inverse(num));
        
        sc.close();
    }
}
