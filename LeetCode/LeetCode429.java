import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode429 {
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                Node node = q.poll();
                list.add(node.val);
                if (!node.children.isEmpty()) {
                    for (Node n : node.children) {
                        q.offer(n);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.children = new ArrayList<>(List.of(new Node(4), new Node(6), new Node(8)));
        root.children.get(0).children = new ArrayList<>(List.of(new Node(1), new Node(3)));
        root.children.get(1).children = new ArrayList<>(List.of(new Node(12)));
        root.children.get(2).children = new ArrayList<>();
        root.children.get(0).children.get(0).children = new ArrayList<>();
        root.children.get(0).children.get(1).children = new ArrayList<>();
        root.children.get(1).children.get(0).children = new ArrayList<>();

        for (List<Integer> l : levelOrder(root)) {
            System.out.println(l);
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
