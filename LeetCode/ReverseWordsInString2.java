public class ReverseWordsInString2 {
    public static String reverseWords(String s) {
    s = s.trim();
    StringBuilder sb = new StringBuilder();
    int i = s.length() - 1;
    
    while (i >= 0) {
        while (i >= 0 && s.charAt(i) == ' ') i--; // skip spaces
        int j = i;
        while (i >= 0 && s.charAt(i) != ' ') i--; // find word
        if (sb.length() > 0) sb.append(" ");
        sb.append(s.substring(i + 1, j + 1));
    }
    return sb.toString();
    }

    public static void main(String[] args) {
        String s = "   the      sky is     blue   ";
        System.out.println(reverseWords(s));
    }
}
