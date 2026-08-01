package DSA.TUF.Binary_Tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
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

        System.out.println(bottomView(root));
    }

    private static List<Integer> bottomView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            Node curr = p.node;
            int l = p.level;

            map.put(l, curr.data);

            if (curr.left != null) {
                q.offer(new Pair(curr.left, l - 1));
            }

            if (curr.right != null) {
                q.offer(new Pair(curr.right, l + 1));
            }

        }

        List<Integer> list = new ArrayList<>();

        for (int n : map.values()) {
            list.add(n);
        }

        return list;
    }
}
