import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {
    List<Integer> list;

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        traverse(root, 0);
        return list;
    }

    public void traverse(TreeNode node, int l) {
        if (node == null) {
            return;
        }

        if (list.size() == l) {
            list.add(node.val);
        }

        traverse(node.right, l + 1);
        traverse(node.left, l + 1);
    }

    public List<Integer> rightSideVieww(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            int value = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                value = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(value);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(3);

        LeetCode199 l = new LeetCode199();
        System.out.println(l.rightSideView(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
