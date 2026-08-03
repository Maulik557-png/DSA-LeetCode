package DSA.TUF.Binary_Tries;

public class LowestCommonAncestor {
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

        System.out.println(lca(root, root.left.left.right, root.left.right).data);

    }

    public static Node lca(Node root, Node p, Node q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (right == null) {
            return left;
        } else if (left == null) {
            return right;
        } else {
            return root;
        }
    }
}
