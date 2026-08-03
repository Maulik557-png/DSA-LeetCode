package DSA.TUF.Binary_Tries;

import java.util.ArrayList;

public class RootToNodePath {
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

        for(int n: pathToNode(root, root.left.left.right)) {
            System.out.println(n);
        }
    }

    private static ArrayList<Integer> pathToNode(Node root, Node target) {
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null || target == null) {
            return path;
        }
        findPath(root, target, path);
        return path;
    }

    private static boolean findPath(Node node, Node target, ArrayList<Integer> path) {
        if (node == null) {
            return false;
        }

        path.add(node.data);

        if (node == target) {
            return true;
        }

        if (findPath(node.left, target, path) || findPath(node.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
