import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode290 {
    public static void main(String[] args) {
        String p = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(p, s));
    }

    public static boolean wordPattern(String p, String s) {
        String[] words = s.split(" ");
        if (p.length() != words.length)
            return false;

        Map<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            String w = words[i];

            if (!Objects.equals(map.put(c, i), map.put(w, i)))
                return false;
        }
        return true;
    }

    // public static boolean wordPattern(String p, String s) {
    // Map<Character, String> map = new HashMap<>();
    // String[] words = s.split(" ");

    // if (words.length != p.length())
    // return false;

    // for (int i = 0; i < words.length; i++) {
    // char c = p.charAt(i);
    // String w = words[i];

    // if (!map.containsKey(c)) {
    // // Check reverse mapping
    // if (map.containsValue(w))
    // return false;
    // map.put(c, w);
    // } else {
    // if (!map.get(c).equals(w))
    // return false;
    // }
    // }
    // return true;
    // }

    // public static boolean wordPattern(String p, String s) {
    // Map<Character, String> map = new HashMap<>();
    // Map<String, Character> reverse = new HashMap<>();
    // String[] words = s.split(" ");
    // if(words.length != p.length()) return false;
    // for (int i = 0; i < words.length; i++) {
    // char c = p.charAt(i);
    // String w = words[i];

    // if (map.containsKey(c)) {
    // if (!map.get(c).equals(w)) return false;
    // } else map.put(c, w);

    // if (reverse.containsKey(w)) {
    // if (reverse.get(w) != c) return false;
    // } else reverse.put(w, c);
    // }
    // return true;
    // }
}
