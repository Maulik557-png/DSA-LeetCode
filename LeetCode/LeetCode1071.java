package LeetCode;

public class LeetCode1071 {

    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        System.out.println(gcdOfStrings(s1, s2));
    }

    public static int gcd(int a, int b)    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static String gcdOfStrings(String str1, String str2) {
        if((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }
        else return "";
    }
}
