package DSA.TUF.Binary_Tries.Iterative_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderDFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(postOrder(root));
    }

    public static List<Integer> postOrder(Node root) {
        Deque<Node> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        st1.push(root);
        while (!st1.isEmpty()) {
            Node node = st1.peek();
            st2.push(node.data);
            st1.pop();
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }

        while (!st2.isEmpty()) {
            list.add(st2.pop());
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
