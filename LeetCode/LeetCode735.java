import java.util.*;

public class LeetCode735 {
    public static void main(String[] args) {
        int[] asteroids = { 3, 5, -6, 2, -1, 4 };
        int[] res = asteroidCollision(asteroids);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && a < 0 && !st.isEmpty() && st.peek() > 0) {
                if (st.peek() < -a) {
                    st.pop();
                } else if (st.peek() == -a) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        int i = res.length - 1;
        while (st.size() > 0) {
            res[i] = st.pop();
            i--;
        }

        return res;
    }
}
