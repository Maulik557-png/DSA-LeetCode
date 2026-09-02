import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.TreeMap;

public class Apr1LeetCode2751 {
    public static void main(String[] args) {

        int[] pos = { 3, 5, 2, 6 };
        int[] hel = { 10, 10, 15, 12 };
        String dir = "RLRL";

        List<Integer> list = survivedRobotsHealths(pos, hel, dir);

        for (Integer n : list) {
            System.out.println(n);
        }
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][];

        for (int i = 0; i < n; i++) {
            robots[i] = new int[] { positions[i], healths[i], directions.charAt(i), i }; // position, health, direction, index
        }

        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R') {
                    if (stack.peek()[1] < robot[1]) {
                        stack.pop();
                        robot[1]--;
                    } else if (stack.peek()[1] == robot[1]) {
                        stack.pop();
                        robot[1] = 0;
                        break;
                    } else {
                        stack.peek()[1]--;
                        robot[1] = 0;
                        break;
                    }
                }
                if (robot[1] > 0) stack.push(robot);
            }
        }

        int[][] remaining = stack.toArray(new int[0][]);
        Arrays.sort(remaining, (a, b) -> a[3] - b[3]);
        List<Integer> res = new ArrayList<>();
        for (int[] r : remaining)
            res.add(r[1]);

        return res;
    }

    // public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    //     TreeMap<Integer, Character> roboDir = new TreeMap<>();
    //     Map<Integer, Integer> roboHealth = new HashMap<>();

    //     for (int i = 0; i < positions.length; i++) {
    //         roboDir.put(positions[i], directions.charAt(i));
    //         roboHealth.put(positions[i], healths[i]);
    //     }

    //     Stack<Integer> stack = new Stack<>();

    //     for (int pos : roboDir.keySet()) {
    //         char dir = roboDir.get(pos);

    //         if (dir == 'R') {
    //             stack.push(pos);
    //         } else {
    //             while (!stack.isEmpty() && roboHealth.containsKey(pos)) {
    //                 int prev = stack.peek();

    //                 if (!roboHealth.containsKey(prev)) {
    //                     stack.pop();
    //                     continue;
    //                 }

    //                 int h1 = roboHealth.get(prev);
    //                 int h2 = roboHealth.get(pos);

    //                 if (h1 < h2) {
    //                     roboHealth.remove(prev);
    //                     stack.pop();
    //                     roboHealth.put(pos, h2 - 1);
    //                 } else if (h1 == h2) {
    //                     roboHealth.remove(prev);
    //                     roboHealth.remove(pos);
    //                     stack.pop();
    //                     break;
    //                 } else {
    //                     roboHealth.put(prev, h1 - 1);
    //                     roboHealth.remove(pos);
    //                     break;
    //                 }
    //             }
    //         }
    //     }

    //     List<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < positions.length; i++) {
    //         if (roboHealth.containsKey(positions[i])) {
    //             list.add(roboHealth.get(positions[i]));
    //         }
    //     }

    //     return list;
    // }

    // public static List<Integer> survivedRobotsHealths(int[] positions, int[]
    // healths, String directions) {
    // TreeMap<Integer, Character> roboDir = new TreeMap<>();
    // Map<Integer, Integer> roboHealth = new HashMap<>();

    // for (int i = 0; i < positions.length; i++) {
    // roboDir.put(positions[i], directions.charAt(i));
    // roboHealth.put(positions[i], healths[i]);
    // }

    // for (int i = 0; i < positions.length; i++) {
    // if(roboDir.get(positions[0]) == 'L') {
    // roboDir.remove(positions[0]);
    // roboHealth.remove(positions[0]);
    // }

    // if(roboDir.get(positions[positions.length - 1]) == 'R') {
    // roboDir.remove(positions[positions.length - 1]);
    // roboHealth.remove(positions[positions.length - 1]);
    // }

    // int curr = positions[i];

    // if(!roboHealth.containsKey(curr)) {
    // continue;
    // }

    // Map.Entry<Integer, Character> lower = roboDir.lowerEntry(curr);
    // Map.Entry<Integer, Character> higher = roboDir.higherEntry(curr);

    // if(lower != null) {
    // if(roboDir.get(curr) != lower.getValue()) {
    // int winner = roboHealth.get(curr) - roboHealth.get(lower.getKey());
    // if(winner > 0) {
    // roboDir.remove(lower.getKey());
    // roboHealth.remove(lower.getKey());
    // roboHealth.put(curr, roboHealth.get(curr) - 1);
    // } else if(winner == 0) {
    // roboDir.remove(curr);
    // roboHealth.remove(curr);
    // roboDir.remove(lower.getKey());
    // roboHealth.remove(lower.getKey());
    // } else {
    // roboDir.remove(curr);
    // roboHealth.remove(curr);
    // roboHealth.put(lower.getKey(), roboHealth.get(lower.getKey()) - 1);
    // }
    // }
    // }

    // if(!roboHealth.containsKey(curr)) {
    // continue;
    // }

    // if(higher != null) {
    // if(roboDir.get(curr) != higher.getValue()) {
    // int winner = roboHealth.get(curr) - roboHealth.get(higher.getKey());
    // if(winner > 0) {
    // roboDir.remove(higher.getKey());
    // roboHealth.remove(higher.getKey());
    // roboHealth.put(curr, roboHealth.get(curr) - 1);
    // } else if(winner == 0) {
    // roboDir.remove(curr);
    // roboHealth.remove(curr);
    // roboDir.remove(higher.getKey());
    // roboHealth.remove(higher.getKey());
    // } else {
    // roboDir.remove(curr);
    // roboHealth.remove(curr);
    // roboHealth.put(higher.getKey(), roboHealth.get(higher.getKey()) - 1);
    // }
    // }
    // }
    // }

    // List<Integer> list = new ArrayList<>();
    // for (int i = 0; i < positions.length; i++) {
    // if(roboHealth.containsKey(positions[i])) {
    // list.add(roboHealth.get(positions[i]));
    // }
    // }
    // return list;
    // }
}
