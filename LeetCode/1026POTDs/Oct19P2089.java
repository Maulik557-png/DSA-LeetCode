
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Oct19P2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int left = (int) Arrays.stream(nums).filter(x -> x < target).count();
        int right = (int) Arrays.stream(nums).filter(x -> x <= target).count();
        return IntStream.range(left, right).boxed().toList();
    }
}
