package DSA.TUF.Binary_Tries;

public class IsSymmetric {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(10);
        root.right.right = new Node(4);
        root.left.left.right = new Node(5);
        root.right.right.left = new Node(5);

        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(Node root) {
        return root == null || symmetric(root.left, root.right);
    }

    private static boolean symmetric(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.data != right.data) {
            return false;
        }

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
