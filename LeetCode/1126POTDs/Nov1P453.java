import java.util.Arrays;

public class Nov1P453 {
    public int minMoves(int[] nums) {
        int n = Arrays.stream(nums).min().getAsInt();
        int moves = 0;

        for (int x : nums) {
            moves += x - n;
        }

        return moves;
    }
}
