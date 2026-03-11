// import java.util.Scanner;

public class Patterns    {

    public static void p1(int n)   {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }   

    public static void p2(int n)    {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p3(int n)    {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println();
        }
    }

    public static void p4(int n)    {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void p5(int n)    {

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p6(int n)    {

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void p7(int n)    {

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j < i*2; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }
    }

    public static void p8(int n)    {

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j < i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= 2*n - 2*i + 1 ; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j < i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }
    }

    public static void p9(int n)    {

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j < i*2; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }

        for(int i = 2; i <= n; i++) {

            for(int j = 1; j < i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= 2*n - 2*i + 1 ; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j < i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }
    }

    public static void p10(int n)    {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = n-1; i >= 1; i--) {
            for(int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p11(int n)    {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {

                if(i%2 == 0)  
                    if(j%2 != 0)
                        System.out.print("0 ");
                    else
                        System.out.print("1 ");
                else
                    if(j%2 != 0)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public static void p12(int n)    {

        if(n >= 10) {
            
            for(int i = 1; i <= n; i++) {
                
                for(int j = 1; j <= i; j++) {
                    if(j <= 9)
                        System.out.print("0" + j + " ");
                    else
                        System.out.print(j + " ");
                }
                
                for(int j = 1; j <= 2*n - 2*i ; j++) {
                    System.out.print("   ");
                }
                
                for(int j = i; j >= 1; j--) {
                    if(j <= 9)
                        System.out.print("0" + j + " ");
                    else
                        System.out.print(j + " ");
                }
                
                System.out.println();
            }
        }

        else    {
            for(int i = 1; i <= n; i++) {
                
                for(int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                }
                
                for(int j = 1; j <= 2*n - 2*i ; j++) {
                    System.out.print("  ");
                }
                
                for(int j = i; j >= 1; j--) {
                    System.out.print(j + " ");
                }
                
                System.out.println();
            }
        }
    }

    public static void p13(int n)    {

        int c = 0;


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i ; j++) {
                if (c < 9) 
                    System.out.print("0" + (c + 1) + " ");
                else
                    System.out.print(c + 1 + " ");
                c+=1;
            }
            System.out.println();
        }
    }

    public static void p14(int n)    {

        char a = 'A';

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print((char) (a + j) + " ");
            }
            System.out.println();
        }
    }

    public static void p15(int n)    {

        char a = 'A';

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i ; j++) {
                System.out.print((char) (a + j - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void p16(int n)    {

        char a = 'A';

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i ; j++) {
                System.out.print((char) (a + i - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void pExtra(int n)    {

        char a = 'A';

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n - i; j++)  {
                System.out.print("  ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print((char) (a + j - 1) + " ");
            }

            for(int j = 1; j <= i - 1; j++) {
                System.out.print((char) (a + j - 1) + " ");
            }

            for(int j = 1; j <= n - i; j++)  {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void p17(int n)    {

        char a = 'A';

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n - i; j++)  {
                System.out.print("  ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print((char) (a + j - 1) + " ");
            }

            for(int j = i - 1; j >= 1; j--) {
                System.out.print((char) (a + j - 1) + " ");
            }

            for(int j = 1; j <= n - i; j++)  {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void p18(int n)    {

        char a = 'A';

        for(int i = 1; i <= n; i++) {

            for(int j = n - i + 1; j <= n; j++) {
                System.out.print((char) (a + j - 1) + " ");
            }

            System.out.println();
        }
    }

    public static void p19(int n)    {

        for(int i = 1; i <= n/2; i++) {

            for(int j = 1; j <= n/2 - i + 1; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= (2 * i) - 2; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= n/2 - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = 2; i <= n/2; i++) {

            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= n - 2 * i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p20(int n)    {

        for(int i = 1; i <= n/2; i++) {

            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= n - 2 * i; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = 2; i <= n/2; i++) {

            for(int j = 1; j <= n/2 - i + 1; j++) {
                System.out.print("* ");
            }

            for(int j = 1; j <= (2 * i) - 2; j++) {
                System.out.print("  ");
            }

            for(int j = 1; j <= n/2 - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
    
    public static void p21(int n)    {

        for(int j = 1; j <= n; j++) {
            System.out.print("* ");
        }
        System.out.println();

        for(int i = 2; i <= n - 1; i++) {
   
            System.out.print("* ");

            for(int j = 2; j <= n - 1; j++) {
                System.out.print("  ");
            }
  
            System.out.print("* ");
            
            System.out.println();
        }

        for(int j = 1; j <= n; j++) {
            System.out.print("* ");
        }
    }
    
    public static void p22(int n)    {

        for(int i = 1; i <= 2*n - 1; i++) {

            for(int j = 1; j <= 2*n - 1; j++) {

                int top = i - 1;
                int left = j - 1;
                int right = 2*n - 1 - j;
                int down = 2*n - 1 - i;

                System.out.print(n - Math.min(Math.min(top, right), Math.min(left, down)) + " ");
            }
            System.out.println();
        }
    }

    public static void p23(int n)   {

        for (int i = 1; i <= n; i++) {

            for (int j = n - i; j > 0; j--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p24(int n)   {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = n - i; j >= 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p25(int n)   {

        for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= n; j++)  {
                if(i == j)  System.out.print("* ");
                else  System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void p26(int n)   {

        for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= n; j++)  {
                if(i + j == n + 1)  System.out.print("* ");
                else  System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void p27(int n)   {
        for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= n; j++)  {
                if((i + j == n + 1) || (i == j))  System.out.print("* ");
                else  System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void p28(int n)   {

        int outerSpace = n/2;
        int innerSpace = -1;

        for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= outerSpace; j++) {
                System.out.print("  ");
            }

            System.out.print("* ");

            for (int j = 1; j <= innerSpace; j++) {
                System.out.print("  ");
            }

            if (i > 1 && i < n) {
                System.out.print("* ");
            }

            if(i <= n/2)  {
                outerSpace--;
                innerSpace += 2;
            } else  {
                outerSpace++;
                innerSpace -= 2;
            }
            System.out.println();
        }
    }

    public static void p29(int n)   {
        int space = n/2;
        int star = 1;
        int val = 1;
        
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < space; j++) {
                System.out.print("  ");
            }

            int cval = val;

            for (int j = 1; j <= star; j++) {
                System.out.print(cval + " ");

                if(j <= star/2)
                    cval++;
                else
                    cval--;
            }

            if(i <= n/2)    {
                space--;
                star += 2;
                val++;
            } else  {
                space++;
                star -= 2;
                val--;
            } 
            System.out.println();
        }
    }

    public static void p30(int n)  {

        int space = 0;
        int star = n;

        for (int i = 1; i <= n; i++)  {
            for (int j = 1; j <= space; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= star; j++) {
                if((i <= n/2 && i > 1) && (j > 1 && j < star)) System.out.print("  ");
                else  System.out.print("* ");
            }

            if(i <= n/2)  {
                space++;
                star -= 2;
            } 
            else  {
                space--;
                star += 2;
            }
            System.out.println();
        }
    }

    public static void p31(int n)   {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {

                // if(i == 1)  {
                //     if(j == n || j <= n/2 + 1)  System.out.print("* "); 
                //     else  System.out.print("  ");
                // } else if(i <= n/2)  {
                //     if(j == n || j == n/2 + 1)  System.out.print("* "); 
                //     else  System.out.print("  ");
                // } else if(i == n/2 + 1)  {
                //     System.out.print("* "); 
                // } else if(i > n/2 + 1 && i < n)  {
                //     if(j == 1 || j == n/2 + 1)  System.out.print("* "); 
                //     else  System.out.print("  ");
                // } else  {
                //     if(j == 1 || j >= n/2 + 1)  System.out.print("* "); 
                //     else  System.out.print("  ");
                // }  
                if(i == n/2+1
						|| j == n/2+1
						|| (i == 1 && j < n/2+1)
						|| (j == n && i < n/2+1)
						|| (i == n && j > n/2)
						|| (j == 1 && i > n/2)) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in); 
        // int n = sc.nextInt();

        int n = 9;
        // p1(n);
        // System.out.println();
        // p2(n);
        // System.out.println();
        // p3(n);
        // System.out.println();
        // p4(n);
        // System.out.println();
        // p5(n);
        // System.out.println();
        // p6(n);
        // System.out.println();
        // p7(n);
        // System.out.println();
        // p8(n);
        // System.out.println();
        // p9(n);
        // System.out.println();
        // p10(n);
        // System.out.println();
        // p11(n);
        // System.out.println();
        // p12(n);
        // System.out.println();
        // p13(n);
        // System.out.println();
        // p14(n);
        // System.out.println();
        // p15(n);
        // System.out.println();
        // p16(n);
        // System.out.println();
        // p17(n);
        // System.out.println();
        // p18(n);
        // System.out.println();
        // p19(n);
        // System.out.println();
        // p20(n);
        // System.out.println();
        // p21(n);
        // System.out.println();
        // p22(n);
        // System.out.println();
        // p23(n);
        // System.out.println();
        // p24(n);
        // System.out.println();
        // p25(n);
        // System.out.println();
        // p26(n);
        // System.out.println();
        // p27(n);
        // System.out.println();
        // p28(n);
        // System.out.println();
        // p29(n);
        // System.out.println();
        // p30(n);
        System.out.println();
        p31(n);

        // sc.close();
    }
}