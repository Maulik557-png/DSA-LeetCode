package DSA.TUF.Binary_Search_Tries;

public class InsertBST {
    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        Node node = root;
        while (true) {
            if (node.data == key) {
                return root;
            }

            if (node.data < key) {
                if (node.right == null) {
                    node.right = new Node(key);
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(key);
                    break;
                }
                node = node.left;
            }
        }

        return root;
    }
}
