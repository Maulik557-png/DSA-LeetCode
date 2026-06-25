import java.util.LinkedList;
import java.util.Queue;

public class LeetCode649 {
    public static void main(String[] args) {
        String senate = "RRDRDR";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int i = 0;
        for (char ch : senate.toCharArray()) {
            if (ch == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
            i++;
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();

            if (ri < di) {
                r.offer(ri + n);
            } else {
                d.offer(di + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
