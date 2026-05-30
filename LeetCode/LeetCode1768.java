public class LeetCode1768 {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();

        if (n > m) {
            while (j < m) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                sb.append(c1);
                sb.append(c2);
                i++;
                j++;
            }
            while (i < n) {
                char c1 = s1.charAt(i);
                sb.append(c1);
                i++;
            }
        } else {
            while (i < n) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                sb.append(c1);
                sb.append(c2);
                i++;
                j++;
            }
            while (j < m) {
                char c2 = s2.charAt(j);
                sb.append(c2);
                j++;
            }
        }

        return sb.toString();
    }

    // public static String mergeAlternately(String word1, String word2) {
    //     if (word1 == null)
    //         return word2;
    //     if (word2 == null)
    //         return word1;

    //     int size = Math.min(word1.length(), word2.length());
    //     StringBuilder sb = new StringBuilder();

    //     for (int i = 0; i < size; i++) {
    //         sb.append(word1.charAt(i)).append(word2.charAt(i));
    //     }
    //     if (size == word1.length())
    //         sb.append(word2.substring(size));
    //     else
    //         sb.append(word1.substring(size));
    //     return sb.toString();
    // }
}
