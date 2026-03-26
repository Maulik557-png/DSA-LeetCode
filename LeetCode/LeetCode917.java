public class LeetCode917    {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
        
    }

    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();

        int l = 0;
        int r = arr.length - 1;

        while(l < r)    {
            if(isEnglish(arr[l]))   {
                while (!isEnglish(arr[r])) {
                    r--;   
                }
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                r--;
            }
            l++;
        }

        return new String(arr);
    }

    public static boolean isEnglish(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}