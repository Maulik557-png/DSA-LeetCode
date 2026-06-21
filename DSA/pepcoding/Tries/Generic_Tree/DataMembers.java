package DSA.pepcoding.Tries.Generic_Tree;

import java.util.*;

public class DataMembers {
    private static class Node {
        private int data;
        private List<Node> children = new ArrayList<>();

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        Node root = null;
        Deque<Node> st = new ArrayDeque<>();
        for (int n : nums) {
            if (n == -1) {
                st.pop();
            } else {
                Node node = new Node();
                node.data = n;

                if (st.size() > 0) {
                    st.peek().children.add(node);
                } else {
                    root = node;
                }
                st.push(node);
            }
        }
        if (root != null) {
            System.out.println(root);
        }
    }
}
