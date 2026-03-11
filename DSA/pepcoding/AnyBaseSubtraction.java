public class AnyBaseSubtraction {
    public static void main(String[] args) {
        int num1 = 256;
        int num2 = 1212;
        int b = 8;

        System.out.println(sub(num1, num2, b));
    }

    private static long sub(int num1, int num2, int b) {

        int borrow = 0;
        int count = 1;
        
        long newNum = 0;

        while (num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            num1 /= 10;
            num2 /= 10;
            
            int temp = digit2 - borrow;
            
            if(temp < digit1)  {
                temp += b;
                borrow = 1;
            } else  {
                borrow = 0;
            }

            int digit = temp - digit1;

            newNum += digit * count;
            count *= 10;
        }

        return newNum;
    }
}
