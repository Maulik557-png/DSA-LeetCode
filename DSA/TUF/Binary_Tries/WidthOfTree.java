package DSA.TUF.Binary_Tries;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(10);
        root.right.right = new Node(4);
        root.left.left.right = new Node(5);
        root.right.right.left = new Node(5);

        System.out.println(widthOfTree(root));
    }

    private static int widthOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int res = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 1));

        // left: 2 * i
        // right: 2 * i + 1
        while (!q.isEmpty()) {

            int level = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < level; i++) {
                Pair p = q.poll();
                Node node = p.node;
                int idx = p.index;

                if (i == 0) {
                    first = idx;
                }

                if (i == level - 1) {
                    last = idx;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, (2 * idx) + 1));
                }

            }
            res = Math.max(res, last - first + 1);
        }

        return res;
    }

    static class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }

        public int getindex() {
            return index;
        }
    }
}
