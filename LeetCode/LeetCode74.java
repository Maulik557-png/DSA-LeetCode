public class LeetCode74 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int val = matrix[row][col];
            if (val == target) {
                return true;
            }
            if (target > val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    // First approach
    // public static boolean searchMatrix(int[][] matrix, int target) {
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;
    //     int top = 0;
    //     int bottom = rows - 1;

    //     while (top <= bottom) {
    //         int mid = top + (bottom - top) / 2;
    //         if (target > matrix[mid][cols - 1]) {
    //             top = mid + 1;
    //         } else if (target < matrix[mid][0]) {
    //             bottom = mid - 1;
    //         } else {
    //             int l = 0;
    //             int r = cols - 1;
    //             while (l <= r) {
    //                 int m = l + (r - l) / 2;
    //                 if (matrix[mid][m] == target) {
    //                     return true;
    //                 }
    //                 if (target > matrix[mid][m]) {
    //                     l = m + 1;
    //                 } else {
    //                     r = m - 1;
    //                 }
    //             }
    //             return false;
    //         }
    //     }
    //     return false;
    // }
}
