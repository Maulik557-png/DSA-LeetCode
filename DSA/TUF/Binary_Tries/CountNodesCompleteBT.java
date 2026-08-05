package DSA.TUF.Binary_Tries;

public class CountNodesCompleteBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(7);
        root.left.left.left = new Node(5);
        System.out.println(countNodes(root));
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right) {
            return (1 << (left)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    public static int leftHeight(Node root) {
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    public static int rightHeight(Node root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
}
