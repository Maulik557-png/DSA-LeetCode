package DSA.TUF.Binary_Search_Tries;

public class DeleteNode {
    public Node delNode(Node root, int x) {
        if (root == null) {
            return null;
        }

        if (root.data == x) {
            return helper(root);
        }

        Node dummy = root;

        while (root != null) {
            if (root.data > x) {
                if (root.left != null && root.left.data == x) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == x) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return dummy;

    }

    public Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node r = root.right;
            Node last = findLastRight(root.left);
            last.right = r;
            return root.left;
        }
    }

    public Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }

        return findLastRight(root.right);
    }
}
