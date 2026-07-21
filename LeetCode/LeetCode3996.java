public class LeetCode3996 {
    public boolean canReach(int[] start, int[] target) {
        int s =  start[0] + start[1];
        int e = target[0] + target[1];

        return s % 2 == e % 2;
    }
}
