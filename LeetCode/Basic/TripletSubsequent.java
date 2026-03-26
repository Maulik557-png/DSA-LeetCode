class TripletSubsequent {
    public static boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        boolean flag = false;

        for(int n : nums)    {
            if(n <= first) 
                first = n;
            else if(n <= second)
                second = n;
            else {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, -2, -3};
        System.out.println(increasingTriplet(nums));
    }
}