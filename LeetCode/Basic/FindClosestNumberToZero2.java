public class FindClosestNumberToZero2 {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closest) || 
               (Math.abs(num) == Math.abs(closest) && num > closest)) {
                closest = num;
            }
        }
        return closest;
    }

    public static void main(String[] args)  {


        int[] arr = {-4, -2, 1, 4, 8};
        FindClosestNumberToZero2 solution = new FindClosestNumberToZero2();
        System.out.println(solution.findClosestNumber(arr));
    }
}
