package LeetCode;

public class LeetCode1832 {

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String s) {
        int mask = 0;
        for (char c : s.toCharArray())  mask |= (1 << (c - 'a'));
        return mask == (1 << 26) - 1;
    }

    // public static boolean checkIfPangram(String s) {
    //     if (s.length() < 26)  return false;
    //     boolean[] seen = new boolean[26];
    //     for (char c : s.toCharArray())  seen[c - 'a'] = true;
    //     for (boolean b : seen)  if (!b)  return false;
    //     return true;
    // }

    // public static boolean checkIfPangram(String s) {
    //     if (s.length() < 26)  return false;
    //     Set<Character> set = new HashSet<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         set.add(s.charAt(i));
    //         if (set.size() == 26)  return true;
    //     }
    //     return false;
    // }
}
