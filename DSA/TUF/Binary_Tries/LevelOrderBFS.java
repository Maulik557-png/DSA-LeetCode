package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBFS {
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
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subTree = new ArrayList<>();
            for (int j = 0; j < level; j++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subTree.add(queue.poll().data);
            }
            list.add(subTree);
        }
        return list;
    }

    public static int getLevel(Node root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }

        return level;
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
