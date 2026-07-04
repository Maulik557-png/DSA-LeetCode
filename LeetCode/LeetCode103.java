import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> subTree = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (flag) {
                    subTree.add(node.val);
                } else {
                    subTree.addFirst(node.val);
                }
            }
            list.add(subTree);
            flag = !flag;
        }
        return list;
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
