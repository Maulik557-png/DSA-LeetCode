import java.util.Arrays;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int[] target = new int[26];
        for(char ch: s.toCharArray())  {
            count[ch - 'a']++;
        }
        for(char ch: t.toCharArray())  {
            target[ch - 'a']++;
        }
        return Arrays.equals(count, target);
    }

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length())  return false;
    //     int[] count = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         count[s.charAt(i) - 'a']++;
    //         count[t.charAt(i) - 'a']--;
    //     }
    //     for (int n : count)  if (n != 0)  return false;
    //     return true;
    // }
}
