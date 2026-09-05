import java.util.LinkedList;
import java.util.Queue;

public class LeetCode662 {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 1));

        // left: 2 * i
        // right: 2 * i + 1
        while (!q.isEmpty()) {

            int level = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < level; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int idx = p.index;

                if (i == 0) {
                    first = idx;
                }

                if (i == level - 1) {
                    last = idx;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, (2 * idx) + 1));
                }

            }
            res = Math.max(res, last - first + 1);
        }

        return res;
    }

    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public int getindex() {
            return index;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }
    }
}
