package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenToLinkedListIterative {
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

        Deque<Node> st = new ArrayDeque<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node node = st.pop();

            if (node.right != null) {
                st.push(node.right);
            }

            if (node.left != null) {
                st.push(node.left);
            }

            if (!st.isEmpty()) {
                node.right = st.peek();
            }

            node.left = null;
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
