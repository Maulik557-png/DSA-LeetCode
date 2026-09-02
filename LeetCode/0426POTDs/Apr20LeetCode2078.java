public class Apr20LeetCode2078 {
    public static void main(String[] args) {
        int[] colors = { 1, 1, 1, 6, 1, 1, 1 };
        System.out.println(maxDistance(colors));
    }

    // Optimized
    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[l])
                res = Math.max(res, i);
            if (colors[i] != colors[r]) 
                res = Math.max(res, n - 1 - i);
        }
        return res;
    }

    // Time Complexity: O(n^2)
    // public static int maxDistance(int[] colors) {
    //     int res = 1;

    //     for (int i = 0; i < colors.length - 1; i++) {
    //         for (int j = colors.length - 1; j > i; j--) {
    //             if (colors[i] != colors[j]) {
    //                 res = Math.max(res, Math.abs(j - i));
    //                 break;
    //             }
    //         }
    //         if (res == colors.length - 1)
    //             return res;
    //     }
    //     return res;
    // }
}
