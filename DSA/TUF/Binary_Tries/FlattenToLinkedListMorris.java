package DSA.TUF.Binary_Tries;

public class FlattenToLinkedListMorris {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        flatten(root);
        traverse(root);
    }

    public static void flatten(Node root) {
        if (root == null) {
            return;
        }

        Node curr = root;
        while(curr != null) {
            if(curr.left != null) {
                Node prev = curr.left;

                while(prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void traverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);

        traverse(root.left);
        traverse(root.right);
    }
}
