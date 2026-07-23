package DSA.TUF.Binary_Tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(7);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        List<List<Integer>> list = verticalTraversal(root);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    private static List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, Map<Integer, Queue<Node>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            map.putIfAbsent(t.vertical, new TreeMap<>());
            map.get(t.vertical).putIfAbsent(t.level, new PriorityQueue<>((a, b) -> a.data - b.data));
            map.get(t.vertical).get(t.level).offer(t.node);

            if (t.node.left != null) {
                q.offer(new Tuple(t.node.left, t.vertical - 1, t.level + 1));
            }

            if (t.node.right != null) {
                q.offer(new Tuple(t.node.right, t.vertical + 1, t.level + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for (Map<Integer, Queue<Node>> levels : map.values()) {
            List<Integer> verticalList = new ArrayList<>();

            for (Queue<Node> nodes : levels.values()) {
                while (!nodes.isEmpty()) {
                    verticalList.add(nodes.poll().data);
                }
            }

            list.add(verticalList);
        }

        return list;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
        }
    }

    public static class Tuple {
        Node node;
        int vertical;
        int level;

        public Tuple(Node node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
}
