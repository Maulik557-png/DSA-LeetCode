import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.Collections;
// import java.util.Map;
// import java.util.TreeMap;

public class LeetCode2225 {

    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        List<List<Integer>> list = findWinners(matches);

        System.out.println(list);
    }

    // public static List<List<Integer>> findWinners(int[][] matches) {
    // Map<Integer, Integer> map = new TreeMap<>();
    // List<Integer> zeroLoses = new ArrayList<>();
    // List<Integer> oneLoses = new ArrayList<>();

    // for (int i = 0; i < matches.length; i++) {
    // map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
    // }

    // for (int i = 0; i < matches.length; i++) {
    // if (map.get(matches[i][1]) == 1)
    // oneLoses.add(matches[i][1]);
    // }

    // for (int i = 0; i < matches.length; i++) {
    // if (!map.containsKey(matches[i][0])) {
    // zeroLoses.add(matches[i][0]);
    // map.put(matches[i][0], 0);
    // }
    // }

    // Collections.sort(zeroLoses, (a, b) -> a - b);
    // Collections.sort(oneLoses, (a, b) -> a - b);

    // return Arrays.asList(zeroLoses, oneLoses);
    // }

    // public static List<List<Integer>> findWinners(int[][] matches) {
    // Map<Integer, Integer> map = new TreeMap<>();
    // List<Integer> zeroLoses = new ArrayList<>();
    // List<Integer> oneLoses = new ArrayList<>();

    // for(int[] team: matches) {
    // map.put(team[0], map.getOrDefault(team[0], 0) + 0);
    // map.put(team[1], map.getOrDefault(team[1], 0) + 1);
    // }

    // for(int n: map.keySet()) {
    // if(map.get(n) == 0) zeroLoses.add(n);
    // else if(map.get(n) == 1) oneLoses.add(n);
    // }

    // return Arrays.asList(zeroLoses, oneLoses);
    // }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> zeroLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        int[] freq = new int[100001];

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (freq[winner] == 0)
                freq[winner] = -1;
            if (freq[loser] == -1)
                freq[loser] = 1;
            else
                freq[loser]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == -1)
                zeroLose.add(i);
            else if (freq[i] == 1)
                oneLose.add(i);
        }

        return Arrays.asList(zeroLose, oneLose);
    }
}
