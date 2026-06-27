package DSA.TUF.Binary_Tries;

public class TwoTreeIdentical {
    public static void main(String[] args) {
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.right.left = new Node(-30);
        root1.right.right = new Node(-15);

        Node root2 = new Node(15);
        root2.left = new Node(10);
        root2.right = new Node(20);
        root2.right.left = new Node(-30);
        root2.right.right = new Node(-15);

        System.out.println(isSameTree(root1, root2));
    }

    public static boolean isSameTree(Node p, Node q) {
        if (p == null || q == null) {
            return (p == q);
        }

        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
