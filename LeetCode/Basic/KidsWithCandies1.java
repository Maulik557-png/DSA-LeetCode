import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies1 {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
		int max = candies[0];
        
		for (int candy : candies) {
            max = Math.max(max, candy);
		}

        for (int candy : candies)    {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    public static void main(String[] args)  {
        int[] candies = {2, 3, 5, 9, 3};
        int extra = 3;
        System.out.println(kidsWithCandies(candies, extra));
    }
}
