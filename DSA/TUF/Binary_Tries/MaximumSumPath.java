package DSA.TUF.Binary_Tries;

public class MaximumSumPath {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.right.left = new Node(-30);
        root.right.right = new Node(-15);

        System.out.println(maxSumPath(root));
    }

    public static int sum;

    public static int maxSumPath(Node node) {
        sum = Integer.MIN_VALUE;
        maxSum(node);
        return sum;
    }

    public static int maxSum(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxSum(node.left);
        int rightSum = maxSum(node.right);

        leftSum = leftSum > 0 ? leftSum : 0;
        rightSum = rightSum > 0 ? rightSum : 0;

        int currSum = node.data + leftSum + rightSum;
        sum = Math.max(sum, currSum);

        return node.data + Math.max(leftSum, rightSum);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            data = val;
        }
    }
}
