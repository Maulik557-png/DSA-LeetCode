public class MergeStringsAlternatively1 {
    public String merge(String word1, String word2) {
        if(word1 == null) return word2;
        if(word2 == null) return word1;

        String word = "";
        String temp;
        int size = Math.min(word1.length(), word2.length());

        for(int i = 0; i < size; i++) {
            temp = null;
            temp = word1.substring(i, i+1) + word2.substring(i, i+1);
            word = word + temp;
        }
        if(size == word1.length())   
            word += word2.substring(size, word2.length());
        else 
            word += word1.substring(size, word1.length());
        return word;
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        MergeStringsAlternatively1 obj = new MergeStringsAlternatively1();
        System.out.println(obj.merge(word1, word2));
    }
}
