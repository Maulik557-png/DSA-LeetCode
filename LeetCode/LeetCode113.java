import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode113 {
    public int sum = 0;
    public List<List<Integer>> res;
    public Deque<Integer> deq;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        deq = new ArrayDeque<>();
        helper(root, targetSum);
        return res;
    }

    public void helper(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        sum += root.val;
        deq.addLast(root.val);

        if (isLeaf(root)) {
            if (sum == target) {
                res.add(new ArrayList<>(deq));
            }
        }

        helper(root.left, target);
        helper(root.right, target);

        sum -= root.val;
        deq.removeLast();
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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
}
