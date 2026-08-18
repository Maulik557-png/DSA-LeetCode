public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) {
            return (1 << (left)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    public int leftHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    public int rightHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
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
