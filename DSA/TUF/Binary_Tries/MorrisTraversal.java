package DSA.TUF.Binary_Tries;

import java.util.ArrayList;

public class MorrisTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(inOrder(root));
    }

    public static  ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {

                    prev.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return res;
    }
}
