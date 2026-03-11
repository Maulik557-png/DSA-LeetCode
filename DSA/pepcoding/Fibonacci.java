import java.util.Scanner;

public class Fibonacci {
    
    private static void printFibonacci(int n)    {

        // int[] array = new int[n];
        // array[0] = 0;
        // array[1] = 1;
        
        // // int sum = 0;
        // for (int i = 2; i < array.length; i++) {
        //     array[i] = array [i - 1] + array[i - 2];
        // }

        // for(int num : array)    {
        //     System.out.println(num);
        // }

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printFibonacci(n);

        sc.close();
    }
}
