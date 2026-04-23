public class LeetCode318 {
    public static void main(String[] args) {
        String[] words = { "adac", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(maxProduct(words));
    }

    // public static int maxProduct(String[] words) {

    // int l = 0;
    // int r = 0;
    // int maxLen = 0;
    // int[] arr = new int[26];

    // for (int i = 0; i < words.length; i++) {
    // maxLen = Math.max(maxLen, words[i].length());
    // }

    // while(l < words.length && r < words.length) {
    // int count = 0;

    // for (int i = 0; i < words[l].length(); i++) {
    // arr[words[l].charAt(i) - 'a']++;
    // }

    // r = l + 1;
    // for (int i = 0; i < words[r].length(); i++) {
    // if(arr[words[r].charAt(i) - 'a'] == 0) {
    // arr[words[r].charAt(i) - 'a']++;
    // count++;
    // }
    // else continue;
    // }
    // if(count == words[r].length()) {
    // maxLen = Math.max(maxLen, words[l].length() * words[r].length());
    // }
    // r++;
    // if(r == words.length - 1) {
    // l++;
    // arr = new int[26];
    // }
    // }
    // return maxLen;
    // }

    public static int maxProduct(String[] words) {

        int n = words.length;
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << (c - 'a'));
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
}
