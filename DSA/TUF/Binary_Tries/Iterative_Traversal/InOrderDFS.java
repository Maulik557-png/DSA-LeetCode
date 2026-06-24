package DSA.TUF.Binary_Tries.Iterative_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderDFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(inOrder(root));
    }

    public static List<Integer> inOrder(Node root) {
        Deque<Node> st = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Node node = root;
        while (node != null || !st.isEmpty()) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }

            node = st.pop();
            list.add(node.data);
            node = node.right;
        }

        return list;
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
