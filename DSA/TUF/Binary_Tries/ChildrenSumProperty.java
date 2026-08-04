package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        convertToChildrenSumProperty(root);

        for (List<Integer> l : traverse(root)) {
            System.out.println(l);
        }
    }

    private static void convertToChildrenSumProperty(Node root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child += root.left.data;
        }

        if (root.right != null) {
            child += root.right.data;
        }

        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null)
                root.left.data = root.data;

            if (root.right != null)
                root.right.data = root.data;
        }

        convertToChildrenSumProperty(root.left);
        convertToChildrenSumProperty(root.right);

        int total = 0;

        if (root.left != null) {
            total += root.left.data;
        }

        if (root.right != null) {
            total += root.right.data;
        }

        if(root.left != null || root.right != null) {
            root.data = total;
        }
    }

    public static List<List<Integer>> traverse(Node root) {
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
}
