// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

public class LeetCode997 {

    public static void main(String[] args) {
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        int n = 3;
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] score = new int[n + 1];

        for (int[] t : trust) {
            score[t[0]]--; 
            score[t[1]]++; 
        }
        for (int i = 1; i <= n; i++) if (score[i] == n - 1) return i;
        return -1;
    }

    // public static int findJudge(int n, int[][] trust) {
    //     if (n == 1)
    //         return 1;

    //     Map<Integer, Integer> map = new HashMap<>();
    //     Set<Integer> set = new HashSet<>();

    //     for (int i = 1; i <= n; i++)
    //         set.add(i);
    //     for (int[] t : trust)
    //         set.remove(t[0]);
    //     if (set.size() == 0)
    //         return -1;

    //     for (int[] t : trust) {
    //         map.put(t[1], map.getOrDefault(t[1], 0) + 1);
    //         if (map.get(t[1]) == n - 1 && set.contains(t[1]))
    //             return t[1];
    //     }
    //     return -1;
    // }

    // public static int findJudge(int n, int[][] trust) {
    // if(n == 1) return 1;
    // Map<Integer, Integer> map = new HashMap<>();
    // Set<Integer> trusted = new HashSet<>();

    // for(int[] t: trust) {
    // map.put(t[1], map.getOrDefault(t[1], 0) + 1);
    // if(map.get(t[1]) == n - 1) {
    // trusted.add(t[1]);
    // }
    // }

    // for(int i = 0; i < trust.length; i++) {
    // if(trusted.contains(trust[i][0])) {
    // trusted.remove(trust[i][0]);
    // }
    // }
    // int res = 0;
    // if(trusted.size() == 0) {
    // res = -1;
    // } else {
    // for(int i: trusted) {
    // res = i;
    // }
    // }
    // return res;
    // }
}
