package DSA.TUF.Binary_Tries.Recursive_Traversal;

public class PreOrderDFS {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        preOrder(root);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);

        preOrder(root.left);
        preOrder(root.right);
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
