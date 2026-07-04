package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(boundaryTraversal(root));
    }

    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (!isLeaf(root)) {
            res.add(root.data);
        }

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    private static void addLeftBoundary(Node node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.data);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void addLeaves(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private static void addRightBoundary(Node node, List<Integer> res) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.data);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
