public class Sep24P3550 {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digits = 0;
            while (num > 0) {
                digits += num % 10;
                num /= 10;
            }

            if (digits == i) {
                return i;
            }

        }
        
        return -1;
    }
}
