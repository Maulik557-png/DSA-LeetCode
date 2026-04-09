public class LeetCode11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            maxArea = Math.max(maxArea, area);

            // Move the shorter line inward
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
    
    // public static int maxArea(int[] height) {
    //     if(height.length == 1)  return 0;
    //     int area = 0;
    //     int heightOfContainer = 0;

    //     for (int i = 0; i < height.length; i++) {   
    //         for (int j = i + 1; j < height.length; j++) {
    //             heightOfContainer = Math.min(height[i], height[j]);
    //             area = Math.max(heightOfContainer * ((i > j)? i - j: j - i), area);
    //         }
    //     }
    //     return area;
    // }

}
