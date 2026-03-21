// Defination of Celebrity is: A person known by everybody and knows no one.

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        /*
         * Input:
         * I | 0 1 2 3 4
         * ——|——————————
         * 0 | x 1 1 1 1
         * 1 | 1 x 0 1 0
         * 2 | 1 0 x 1 0
         * 3 | 0 0 0 x 0
         * 4 | 0 1 0 1 x
         *
         * Output: 3
         */

        int[][] nums = new int[5][5];
        for (int i = 0; i < nums.length; i++) {
            nums[i][i] = 0;
        }
        nums[0][1] = 1;
        nums[0][2] = 1;
        nums[0][3] = 1;
        nums[0][4] = 1;
        nums[1][0] = 1;
        nums[1][2] = 0;
        nums[1][3] = 1;
        nums[1][4] = 0;
        nums[2][0] = 1;
        nums[2][1] = 0;
        nums[2][3] = 1;
        nums[2][4] = 0;
        nums[3][0] = 0;
        nums[3][1] = 0;
        nums[3][2] = 0;
        nums[3][4] = 0;
        nums[4][0] = 0;
        nums[4][1] = 1;
        nums[4][2] = 0;
        nums[4][3] = 1;
        System.out.println(findCelebrity(nums));
    }

    public static int findCelebrity(int[][] nums) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int p1 = st.pop();
            int p2 = st.pop();

            if (nums[p1][p2] == 1) {
                // if p1 knows p2 -> p1 cannot be celebrity
                st.push(p2);
            } else {
                // if p1 does not know p2 -> p2 cannot be celebrity
                st.push(p1);
            }
        }

        int c = st.pop();
        for (int i = 0; i < nums.length; i++) {
            if (i == c)
                continue;
            if (nums[i][c] == 0 || nums[c][i] == 1) {
                return -1;
            }
        }
        return c;
    }
}
