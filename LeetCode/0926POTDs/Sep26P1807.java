import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sep26P1807 {
    public static String evaluate(String s, List<List<String>> pairs) {
        Map<String, String> map = new HashMap<>();

        for (List<String> l : pairs) {
            map.put(l.get(0), l.get(1));
        }

        StringBuilder sb = new StringBuilder();

        int l = 0;
        int r = 0;

        while (l < s.length() && r < s.length()) {
            if (s.charAt(l) == '(') {
                r = l + 1;
                StringBuilder sbb = new StringBuilder();
                while (s.charAt(r) != ')') {
                    sbb.append(s.charAt(r));
                    r++;
                }

                sb.append(map.getOrDefault(sbb.toString(), "?"));
                l = r + 1;
                continue;
            }
            sb.append(s.charAt(l));
            l++;
        }

        return sb.toString();
    }
}
