public class SpanOfArray    {

    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 100);
        }
        for (int i : nums) {
            System.out.println(i);
        }
        System.out.println("============\n" + findSpan(nums));
    }

    private static int findSpan(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}