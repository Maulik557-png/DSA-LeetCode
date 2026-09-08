import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode513 {
    int depth = -1;
    int leftMost = 0;

    public int findBottomLeftValueee(TreeNode root) {
        dfs(root, 0);
        return leftMost;
    }

    public void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }

        if (d > depth) {
            depth = d;
            leftMost = root.val;
        }

        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

    public int findBottomLeftValuee(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node = root;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }

        return node.val;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subTree = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                subTree.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(subTree);
        }

        return list.get(list.size() - 1).get(0);
    }

    public class TreeNode {
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
