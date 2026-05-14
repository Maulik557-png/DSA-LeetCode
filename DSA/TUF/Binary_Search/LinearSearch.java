package DSA.TUF.Binary_Search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int target = 5;
        System.out.println(linearSearch(nums, target));
    }

    // O(n)
    private static int linearSearch(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
