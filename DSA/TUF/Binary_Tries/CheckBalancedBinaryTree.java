package DSA.TUF.Binary_Tries;

public class CheckBalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        boolean left = isBalanced(node.left);
        boolean right = isBalanced(node.right);

        if (!left || !right) {
            return false;
        }

        return true;
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
