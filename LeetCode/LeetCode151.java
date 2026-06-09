import java.util.ArrayList;
import java.util.List;

public class LeetCode151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                continue;
            }
            if (sb.length() != 0) {
                list.add(sb.toString());
                sb.setLength(0);
            } else {
                continue;
            }
        }
        list.add(sb.toString());

        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i));
            if (i > 0) {
                res.append(' ');
            }
        }
        return res.toString();
    }
}
