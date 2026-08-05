package DSA.TUF.Binary_Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesAtKDistance {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(7);
        root.left.left.right = new Node(5);

        System.out.println(distanceK(root, root, 3));
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> map = parents(root);
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        int distance = 0;
        q.offer(target);
        while (!q.isEmpty() && distance < k) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Node n = q.poll();
                visited.add(n);

                Node parent = map.get(n);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }

                if (n.left != null && !visited.contains(n.left)) {
                    visited.add(n.left);
                    q.offer(n.left);
                }

                if (n.right != null && !visited.contains(n.right)) {
                    visited.add(n.right);
                    q.offer(n.right);
                }
            }

            distance++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Node n : q) {
            list.add(n.data);
        }

        return list;
    }

    public static Map<Node, Node> parents(Node root) {
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Node node = q.poll();

                if (node.left != null) {
                    map.put(node.left, node);
                    q.offer(node.left);
                }

                if (node.right != null) {
                    map.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }

        return map;
    }
}
