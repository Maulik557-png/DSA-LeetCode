package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> list = levelOrder(root);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        Deque<Node> dual = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean flag = true;

        if (root == null) {
            return list;
        }

        dual.add(root);
        while (!dual.isEmpty()) {
            int level = dual.size();
            LinkedList<Integer> subTree = new LinkedList<>();
            for (int j = 0; j < level; j++) {
                Node curr = dual.poll();

                if (curr.left != null) {
                    dual.offer(curr.left);
                }
                if (curr.right != null) {
                    dual.offer(curr.right);
                }

                if (flag) {
                    subTree.add(curr.data);
                }
                else {
                    subTree.addFirst(curr.data);
                }
            }
            list.add(subTree);
            flag = !flag;
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
