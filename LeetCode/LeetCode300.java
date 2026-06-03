public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int l = 0;
            int r = size - 1;
            int res = size;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] >= n) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            arr[res] = n;
            if (res == size) {
                size++;
            }
        }
        return size;
    }
}
