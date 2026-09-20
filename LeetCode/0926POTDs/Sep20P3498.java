public class Sep20P3498 {
    public int reverseDegree(String s) {
        int[] freq = new int[26];
        int d = 26;
        for (int i = 0; i < freq.length; i++) {
            freq[i] = d--;
        }

        int res = 0;
        int i = 1;
        for (char ch : s.toCharArray()) {
            res += (i++) * freq[ch - 'a'];
        }

        return res;
    }
}
