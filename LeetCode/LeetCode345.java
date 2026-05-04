public class LeetCode345 {
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s)); 
    }
    
    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            while (i < j && vowels.indexOf(arr[i]) == -1) i++;
            while (i < j && vowels.indexOf(arr[j]) == -1) j--;

            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }

}
