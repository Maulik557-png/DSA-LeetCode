public class Sep10P2265 {
    // approach 1 (first attempt)
    public int averageOfSubtree(TreeNode root) {
        int[] count = new int[1];
        traverse(root, count);
        return count[0];
    }

    public void traverse(TreeNode node, int[] count) {
        if (node == null) {
            return;
        }

        int[] s = new int[2];
        getSum(node, s);

        if (s[1] == 1) {
            count[0]++;
        } else {
            int avg = s[0] / s[1];
            if (avg == node.val) {
                count[0]++;
            }
        }

        traverse(node.left, count);
        traverse(node.right, count);
    }

    public void getSum(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }

        sum[0] += node.val;
        sum[1]++;

        getSum(node.left, sum);
        getSum(node.right, sum);
    }

    // Approach 2 (better)
    public int averageOfSubtreee(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    public int[] dfs(TreeNode node, int[] count) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(node.left, count);
        int[] right = dfs(node.right, count);

        int sum = left[0] + right[0] + node.val;
        int nodes = left[1] + right[1] + 1;

        if (sum / nodes == node.val) {
            count[0]++;
        }

        return new int[] { sum, nodes };
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);

        System.out.println(new Sep10P2265().averageOfSubtree(root));
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
