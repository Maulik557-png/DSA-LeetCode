package DSA.TUF.Binary_Tries;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
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

        System.out.println(leftView(root));
    }

    static List<Integer> list;

    private static List<Integer> leftView(Node root) {

        list = new ArrayList<>();
        traverse(root, 0);
        return list;
    }

    private static void traverse(Node node, int l) {
        if (node == null) {
            return;
        }

        if (list.size() == l) {
            list.add(node.data);
        }

        traverse(node.left, l + 1);
        traverse(node.right, l + 1);
    }
}
