public class LeetCode3041 {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int best = 1;
        int keep = 1;
        int bump = 1;
        int last = -10;
        for (int x : nums) {
            switch (x - last) {
                case 0 -> bump = keep + 1;
                case 1 -> {
                    keep++;
                    bump++;
                }
                case 2 -> {
                    keep = bump + 1;
                    bump = 1;
                }
                default -> keep = bump = 1;
            }
            best = Math.max(best, Math.max(keep, bump));
            last = x;
        }
        
        return best;
    }
}
