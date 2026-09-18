public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNextChild(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = getNextChild(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    public Node getNextChild(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }

            if (node.right != null) {
                return node.right;
            }

            node = node.next;
        }

        return null;
    }

    public class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }
    }
}
