import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {
    public static void main(String[] args) {
        RecentCounter obj = new LeetCode933().new RecentCounter();
        int t = 3000;
        int param_1 = obj.ping(t);
        System.out.println(param_1);
    }

    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
