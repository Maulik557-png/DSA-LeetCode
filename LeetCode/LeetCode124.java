public class LeetCode124 {
    public static int[] sum = new int[1];

    public static int maxPathSum(TreeNode root) {
        sum[0] = Integer.MIN_VALUE;
        maxSum(root);
        return sum[0];
    }

    public static int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = maxSum(node.left);
        int rightSum = maxSum(node.right);

        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);

        sum[0] = Math.max(sum[0], node.val + leftSum + rightSum);
        return node.val + Math.max(leftSum, rightSum);
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
