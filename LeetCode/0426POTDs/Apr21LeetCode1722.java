import java.util.*;

public class Apr21LeetCode1722 {
    public static void main(String[] args) {
        int[] source = { 1, 2, 3, 4 };
        int[] target = { 2, 1, 4, 5 };
        int[][] allowedSwaps = { { 0, 1 }, { 2, 3 } };
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    private static int[] parent;

    private static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    private static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];

        // Initialize each index as its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step 1: Build connected components
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        // Step 2: Group indices by their root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Step 3: For each group, count mismatches
        int cost = 0;
        for (List<Integer> indices : groups.values()) {

            // Count source elements in this group
            Map<Integer, Integer> sourceCount = new HashMap<>();
            for (int i : indices) {
                sourceCount.put(source[i], sourceCount.getOrDefault(source[i], 0) + 1);
            }

            // Try to match each target element
            for (int i : indices) {
                int t = target[i];
                if (sourceCount.getOrDefault(t, 0) > 0) {
                    sourceCount.put(t, sourceCount.get(t) - 1); // matched!
                } else {
                    cost++; // no match → Hamming distance
                }
            }
        }
        return cost;
    }

    // Method 2 learned from ChatGPT
    // public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    //     int n = source.length;

    //     UnionFind uf = new UnionFind(n);

    //     // Step 1: Build connected components
    //     for (int[] swap : allowedSwaps) {
    //         uf.union(swap[0], swap[1]);
    //     }

    //     // Step 2: Group indices by parent
    //     Map<Integer, List<Integer>> groups = new HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         int parent = uf.find(i);
    //         groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
    //     }

    //     int result = 0;

    //     // Step 3: For each group, match values
    //     for (List<Integer> group : groups.values()) {
    //         Map<Integer, Integer> freq = new HashMap<>();

    //         // Count source values
    //         for (int idx : group) {
    //             freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
    //         }

    //         // Try to match target values
    //         for (int idx : group) {
    //             int val = target[idx];
    //             if (freq.getOrDefault(val, 0) > 0) {
    //                 freq.put(val, freq.get(val) - 1);
    //             } else {
    //                 result++; // mismatch
    //             }
    //         }
    //     }
    //     return result;
    // }

    // // Union-Find (Disjoint Set)
    // private static class UnionFind {
    //     int[] parent;

    //     public UnionFind(int n) {
    //         parent = new int[n];
    //         for (int i = 0; i < n; i++) {
    //             parent[i] = i;
    //         }
    //     }

    //     public int find(int x) {
    //         if (parent[x] != x) {
    //             parent[x] = find(parent[x]); // path compression
    //         }
    //         return parent[x];
    //     }

    //     public void union(int a, int b) {
    //         int pa = find(a);
    //         int pb = find(b);
    //         if (pa != pb) {
    //             parent[pa] = pb;
    //         }
    //     }
    // }

    /*
    * First Try
    * Approach:
    * Assume that:
    * [[0,4],[4,2],[1,3],[1,4]] in this if we can any how find all the possible swaps we can solve this problem. 
    * 
    * Like: 0 can swap 4 now let's search can 4 swap anyone? if so (and yes in this case) [4,2] then we can say that pair [0, 2] is also possible.. 
    * 
    * similarly it's opposite as well
    * Like: 1 can swap 3 means 3 can swap 1 now let's search 1 swap anyone? if so (and yes in this case) [1,4] then we can say that pair [3, 4] is also possible..
    * 
    * If we find all the possible pairs like this then loop in the source array and see if current element index and current element index in target array exists as a pair of allowedSwap? Is yes then move ahead and if not count is a Hamming distance.
    */
    // public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int[] is : allowedSwaps) {
    //         map.put(is[0], is[1]);
    //     }
        
    //     for (int n : map.values()) {
    //         if (map.containsKey(n)) {
    //             int key = getKey(n, map);
    //             map.put(key, n);
    //         }
    //     }

    //     List<Integer> trg = new ArrayList<>();
    //     for (int value : target) {
    //         trg.add(value);
    //     }

    //     List<Integer> src = new ArrayList<>();
    //     for (int value : target) {
    //         src.add(value);
    //     }

    //     for (int i = 0; i < src.size(); i++) {
    //         int n = src.get(i);
    //         int j = trg.indexOf(n);
    //     }
    //     return 0;
    // }

    // private static int getKey(int val, Map<Integer, Integer> map) {
    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (Objects.equals(val, entry.getValue())) {
    //             return entry.getKey();
    //         }
    //     }
    //     return 0;
    // }
}
