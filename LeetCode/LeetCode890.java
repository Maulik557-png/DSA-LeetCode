import java.util.ArrayList;
import java.util.List;

public class LeetCode890 {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    // public static List<String> findAndReplacePattern(String[] words, String pattern) {
    //     List<String> res = new ArrayList<>();
    //     for (String word : words) if (check(word, pattern)) res.add(word);
    //     return res;
    // }

    // private static boolean check(String a, String b) {
    //     for (int i = 0; i < a.length(); i++) if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
    //     return true;
    // }

    public static List<String> findAndReplacePattern(String[] words, String t) {
        List<String> list = new ArrayList<>();
        for(String s: words) if(isIsomorphic(t, s)) list.add(s);
        return list;
    }

    private static boolean isIsomorphic(String s, String t) {
        int arrs[] = new int[128];
        int arrt[] = new int[128];
        for(int i = 0 ;i<s.length(); i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            if(arrs[chars] != arrt[chart]) return false;
            arrs[chars] = i+1;
            arrt[chart] = i+1;
        }
        return true;
    }
}
