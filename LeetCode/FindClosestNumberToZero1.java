public class FindClosestNumberToZero1 {

    public int findClosestNumber(int[] nums) {
        // Instead of fixed sizes, use ArrayLists
        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();

        // Separate negatives and positives
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) 
                left.add(nums[i]);
            else 
                right.add(nums[i]);
            
        }

        // Handle cases when one side is empty
        if (left.isEmpty()) 
            return right.stream().min(Integer::compare).get(); // smallest positive

        if (right.isEmpty()) 
            return left.stream().max(Integer::compare).get(); // largest negative

        // Find largest negative
        int largest = left.get(0);
        for (int i = 1; i < left.size(); i++) {
            if (left.get(i) > largest) // closer to 0
                largest = left.get(i);
        }

        // Find smallest positive
        int smallest = right.get(0);
        for (int i = 1; i < right.size(); i++) {
            if (right.get(i) < smallest) // closer to 0
                smallest = right.get(i);
        }

        if (Math.abs(largest) < Math.abs(smallest)) 
            return largest;
        else if (Math.abs(largest) > Math.abs(smallest)) 
            return smallest;
        else 
            return Math.max(largest, smallest); // prefer positive on tie
    }

    public static void main(String[] args) {
        int[] arr = { -4, -2, 1, 4, 8 };

        FindClosestNumberToZero1 solution = new FindClosestNumberToZero1();
        int sol = solution.findClosestNumber(arr);

        System.out.println(sol);
    }
}