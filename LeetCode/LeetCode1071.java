public class LeetCode1071 {

    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        System.out.println(gcdOfStrings(s1, s2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        } else {
            return "";
        }
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
