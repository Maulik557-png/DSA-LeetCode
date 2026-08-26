public class LeetCode226 {
    public static TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public static void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        helper(node.left);
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        invertTree(root);
        traverse(root);
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

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
