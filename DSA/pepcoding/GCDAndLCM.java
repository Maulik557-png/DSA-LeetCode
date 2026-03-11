import java.util.Scanner;

public class GCDAndLCM {

    private static void findGCDAndLCM(int num1, int num2)  {

        long orginalNum1 = num1;
        long orginalNum2 = num2;

        int limit = Math.min(num1, num2);
        // int i = limit / 2;

        int gcd = limit;

        // while(i > 0) {
        //     if(limit % i == 0)
        //         if(Math.max(num1, num2) % i == 0){
        //             gcd = i;
        //             break;
        //         }
        //     i--;
        // }
        
        // Alternative Solution (better)
        while(num1 % num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        gcd = num2;

        long lcm = (orginalNum1 * orginalNum2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        findGCDAndLCM(num1, num2);
        
        sc.close();
    }
}
