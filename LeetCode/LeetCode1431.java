package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extra = 3;
        System.out.println(kidsWithCandies(candies, extra));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        int max = candies[0];
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
