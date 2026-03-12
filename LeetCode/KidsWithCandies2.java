import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWithCandies2 {
        public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies)
                     .mapToObj(c -> c + extraCandies >= max)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 9, 3};
        int extra = 3;
        System.out.println(kidsWithCandies(candies, extra));
    }
}
