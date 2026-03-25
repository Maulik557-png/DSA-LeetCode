import java.util.Scanner;

public class IsPrime {

    private static void printAllPrime(int low, int high) {
        

        for (int n = low; n <= high; n++) {

            int count = 0;
            for (int div = 2; div * div <= n; div++) {
                if(n % div == 0)  {
                    count++;
                    break;
                }
            }

            if(count == 0)
                System.out.println(n);        
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();

        printAllPrime(low, high);

        sc.close();
    }
}
