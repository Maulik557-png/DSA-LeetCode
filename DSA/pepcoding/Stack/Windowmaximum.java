public class Windowmaximum {
    public static void main(String[] args) {
        int[] nums = { 6, 2, 5, 4, 5, 1, 6 };
        int k = 3;
        int[] res = slidingWindowMax(nums, k);

        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] slidingWindowMax(int[] nums, int k)    {

        int left = 0;
        int right = 1;
        int window = 0;
        int max = 0;

        int[] res = new int[nums.length];

        for (int i = 0; i < k; i++) {
            window += nums[i];
        }


        for(; right < nums.length; right++) {
            window += nums[right] - nums[left];
        }


        return null;
    }

}
