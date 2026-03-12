public class MergeStringsAlternatively2 {
    public String merge(String word1, String word2) {
        if(word1 == null) return word2;
        if(word2 == null) return word1;

        int size = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (size == word1.length()) 
            sb.append(word2.substring(size));
        else 
            sb.append(word1.substring(size));
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        MergeStringsAlternatively2 obj = new MergeStringsAlternatively2();
        System.out.println(obj.merge(word1, word2));
    }
}
