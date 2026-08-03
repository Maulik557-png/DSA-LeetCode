package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RootToLeafPath {

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

        paths(root);

        for(ArrayList<Integer> l: list) {
            System.out.println(l);
        }
    }

    static ArrayList<ArrayList<Integer>> list;
    static Deque<Integer> q;
    
	private static ArrayList<ArrayList<Integer>> paths(Node root) {
		list = new ArrayList<>();
		q = new ArrayDeque<>();
		helper(root);
		return list;
	}
	
	private static void helper(Node node) {
		if (node == null) {
			return;
		}
		
		if (isLeaf(node)) {
			q.addLast(node.data);
			list.add(new ArrayList<>(q));
			q.removeLast();
			return;
		}
		
		q.addLast(node.data);
		
		helper(node.left);
		helper(node.right);
		
		q.removeLast();
	}
	
	private static boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
}
