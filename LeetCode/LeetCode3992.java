public class LeetCode3992 {
    public String rearrangeString(String s, char x, char y) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        for(char c: arr) {
            freq[c - 'a']++;
        }

        if(freq[x - 'a'] == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: arr) {
            if(ch == x) {
                continue;
            }
            sb.append(ch);
        }

        for(int i = freq[x - 'a']; i > 0; i--) {
            sb.append(x);
        }

        String t = sb.toString();
        return t;
    }
}
