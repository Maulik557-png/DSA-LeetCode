import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode437 {
    // Approach 2
    // public int pathSum(TreeNode root, int target) {
    //     Map<Long, Integer> pref = new HashMap<>();
    //     pref.put(0L, 1);
    //     return dfs(root, 0L, target, pref);
    // }

    // private int dfs(TreeNode node, long sum, int target, Map<Long, Integer> pref) {
    //     if (node == null) {
    //         return 0;
    //     }

    //     sum += node.val;
    //     int count = pref.getOrDefault(sum - target, 0);
    //     pref.put(sum, pref.getOrDefault(sum, 0) + 1);
    //     count += dfs(node.left, sum, target, pref);
    //     count += dfs(node.right, sum, target, pref);
    //     pref.put(sum, pref.get(sum) - 1);
    //     return count;
    // }

    // Approach 1
    public int pathSum(TreeNode root, int targetSum) {
        List<List<TreeNode>> paths = nodeToLeaf(root);
        Set<Path> countedPaths = new HashSet<>();
        int count = 0;
        for (List<TreeNode> l : paths) {
            count += countSubarrays(l, targetSum, countedPaths);
        }

        return count;
    }

    public int countSubarrays(List<TreeNode> list, int target, Set<Path> countedPaths) {
        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(0L, new ArrayList<>(List.of(-1)));

        long curr = 0;
        int count = 0;

        for (int end = 0; end < list.size(); end++) {
            curr += list.get(end).val;

            long req = curr - target;
            List<Integer> starts = map.get(req);

            if (starts != null) {
                for (int startPrefixIndex : starts) {
                    int startIndex = startPrefixIndex + 1;
                    Path validPath = new Path(list.get(startIndex), list.get(end));

                    if (countedPaths.add(validPath)) {
                        count++;
                    }
                }
            }

            map.computeIfAbsent(curr, k -> new ArrayList<>()).add(end);
        }

        return count;
    }

    public List<List<TreeNode>> res;
    public Deque<TreeNode> deq;

    public List<List<TreeNode>> nodeToLeaf(TreeNode root) {
        res = new ArrayList<>();
        deq = new ArrayDeque<>();

        helper(root);

        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        deq.addLast(root);

        if (isLeaf(root)) {
            res.add(new ArrayList<>(deq));
        }

        helper(root.left);
        helper(root.right);

        deq.removeLast();
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        LeetCode437 l = new LeetCode437();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(l.pathSum(root, 8));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    public static class Path {
        TreeNode start;
        TreeNode end;

        Path(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }

        public TreeNode getStart() {
            return start;
        }

        public TreeNode getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Path))
                return false;

            Path other = (Path) o;
            return start == other.start && end == other.end;
        }

        @Override
        public int hashCode() {
            return 31 * System.identityHashCode(start) + System.identityHashCode(end);
        }
    }
}
