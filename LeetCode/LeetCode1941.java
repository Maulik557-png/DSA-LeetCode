package LeetCode;

public class LeetCode1941 {
    public static void main(String[] args) {
        String s = "abacbc";
        System.out.println(areOccurrencesEqual(s));
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        for(char ch: s.toCharArray())  arr[ch - 'a']++;
        int count = arr[s.charAt(0) - 'a'];
        for(int i = 0; i < arr.length; i++)  if(arr[i] > 0)  if(arr[i] != count)  return false;
        return true;
    }

    // public static boolean areOccurrencesEqual(String s) {
    //     int[] freq = new int[26];

    //     for (char c : s.toCharArray())  freq[c - 'a']++;

    //     int expected = 0;
    //     for (int f : freq) {
    //         if (f == 0)  continue;
    //         if (expected == 0)  expected = f;
    //         else if (f != expected)  return false;
    //     }
    //     return true;
    // }
}
