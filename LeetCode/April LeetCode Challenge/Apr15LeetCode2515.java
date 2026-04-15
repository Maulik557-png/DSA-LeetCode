public class Apr15LeetCode2515 {
    public static void main(String[] args) {
        String[] words = { "hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje", "fghofclnwp",
                "djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp" };
        String target = "zemkwvqrww";
        int startIndex = 8;
        System.out.println(closestTarget(words, target, startIndex));
    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                minDiff = Math.min(minDiff, dist);
            }
        }
        return minDiff == Integer.MAX_VALUE? -1: minDiff;
    }

    // public static int closestTarget(String[] words, String target, int
    // startIndex) {
    // int n = words.length;
    // int min = Integer.MAX_VALUE;
    // for (int i = 0; i < n; i++) {
    // int forward = (startIndex + i) % n;
    // int backward = (startIndex - i + n) % n;
    // if (words[forward].equals(target) || words[backward].equals(target)) {
    // min = i;
    // break;
    // }
    // }
    // return min == Integer.MAX_VALUE ? -1 : min;
    // }

    // public static int closestTarget(String[] words, String target, int
    // startIndex) {
    // int n = words.length;
    // int count = 0;
    // int min = Integer.MAX_VALUE;
    // for(String s: words) if(s.equals(target)) count++;
    // if(count == 0) return -1;

    // if(words[startIndex].equals(target)) return 0;

    // int i = startIndex;
    // int ci = 0;
    // for(int k = 0; k < n; k++) {
    // ci++;
    // if(words[(i + 1) % n].equals(target)) {
    // min = Math.min(min, ci);
    // }
    // i++;
    // }

    // int j = startIndex;
    // int cj = 0;
    // for(int k = 0; k < n; k++) {
    // cj++;
    // if(words[(j - 1 + n) % n].equals(target)) {
    // min = Math.min(min, cj);
    // }
    // j--;
    // }
    // return min;
    // }
}
