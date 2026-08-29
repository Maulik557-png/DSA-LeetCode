public class LeetCode1145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new LeetCode1145().btreeGameWinningMove(root, 5, 1));
    }

    boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findNode(root, x);

        int[] c = new int[1];

        int l = 0;
        int r = 0;
        if (xNode.left != null) {
            c[0] = 0;
            countNodes(xNode.left, c);
            l = c[0];
        }

        if (xNode.right != null) {
            c[0] = 0;
            countNodes(xNode.right, c);
            r = c[0];
        }

        int xCount = 1 + l + r;
        int parentSide = n - xCount;

        return Math.max(Math.max(l, r), parentSide) > n / 2;
    }

    TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode found = findNode(root.left, value);
        if (found != null) {
            return found;
        }

        return findNode(root.right, value);
    }

    void countNodes(TreeNode root, int[] c) {
        if (root == null) {
            return;
        }

        c[0]++;

        countNodes(root.left, c);
        countNodes(root.right, c);
    }

    static class TreeNode {
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
