package DSA.TUF.Binary_Tries;

public class DiameterOfTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);

        System.out.println(diameter(root));
    }

    private static int d;

    private static int diameter(Node root) {
        maxDepth(root);
        return d;
    }

    private static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        d = Math.max(d, left + right);
        return 1 + Math.max(left, right);
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
