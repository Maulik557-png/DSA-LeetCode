package DSA.TUF.Binary_Tries;

import java.util.List;

public class VeerticaOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> list = verticaOrderTraversal(root);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    private static List<List<Integer>> verticaOrderTraversal(Node root) {
            



        return null;
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
