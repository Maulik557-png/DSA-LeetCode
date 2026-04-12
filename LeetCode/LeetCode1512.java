public class LeetCode1512 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 6, 2};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int pair = 0;
        for(int n: nums) freq[n]++;
        for(int n: freq) if(n > 1) pair += ((n * (n - 1)) / 2); 
        return pair;
    }
    
    // public static int numIdenticalPairs(int[] nums) {
    //     int c = 0;
    //     for(int i = 0 ; i < nums.length; i++) 
    //         for(int j = 1; j < nums.length; j++) 
    //             if(i < j && nums[i] == nums[j]) 
    //                 c++;
    //     return c;
    // }
}
