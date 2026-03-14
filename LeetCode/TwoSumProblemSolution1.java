// Time Complexit : O(n2)

public class TwoSumProblemSolution1 {
        public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args)   {
        int[] nums = {3,3};
        int target = 6;
        int[] solution = twoSum(nums, target);
        System.out.println("[" + solution[0] + "," + solution[1] + "]");
    } 
}
