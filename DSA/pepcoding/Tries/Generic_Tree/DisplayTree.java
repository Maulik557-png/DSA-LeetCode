package DSA.pepcoding.Tries.Generic_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DisplayTree {
    private static class Node {
        private int data;
        private List<Node> children = new ArrayList<>();
    }

    private static class GenericTree {
        public Node create(int[] nums) {
            Deque<Node> stack = new ArrayDeque<>();
            Node root = null;

            for (int num : nums) {
                if (num == -1) {
                    stack.pop();
                } else {
                    Node node = new Node();
                    node.data = num;

                    if (stack.isEmpty()) {
                        root = node;
                    } else {
                        stack.peek().children.add(node);
                    }
                    stack.push(node);
                }
            }
            return root;
        }

        public void display(Node root) {
            String str = root.data + ": ";

            for (Node child : root.children) {
                str += child.data + ", ";
            }
            System.out.println(str);

            for (Node child : root.children) {
                display(child);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        GenericTree tree = new GenericTree();
        Node root = tree.create(nums);
        tree.display(root);
    }
}
