package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConstructBinaryTree2 {
    public static void main(String[] args) {
        int[] in = { 9, 3, 15, 20, 7 };
        int[] post = { 3, 9, 20, 15, 7 };

        Node node = buildTree1(in, post);

        for (List<Integer> l : traverse(node)) {
            System.out.println(l);
        }
    }

    public static Node buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        Node root = new Node(rootVal);

        int leftSubLength = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                leftSubLength = i;
                break;
            }
        }

        int[] newInOrderLeft = Arrays.copyOfRange(inorder, 0, leftSubLength);
        int[] newInOrderRight = Arrays.copyOfRange(inorder, leftSubLength + 1, inorder.length);

        int[] newPostOrderLeft = Arrays.copyOfRange(postorder, 0, leftSubLength);
        int[] newPostOrderRight = Arrays.copyOfRange(postorder, leftSubLength, postorder.length - 1);

        root.left = buildTree1(newInOrderLeft, newPostOrderLeft);
        root.right = buildTree1(newInOrderRight, newPostOrderRight);

        return root;
    }

    public static Map<Integer, Integer> inorderMap;

    public static Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) {
            return null;
        }
        
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public static Node helper(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        Node root = new Node(rootVal);

        int rootInorderIdx = inorderMap.get(rootVal);
        int leftSubLength = rootInorderIdx - inStart;

        root.left = helper(postorder, postStart, postStart + leftSubLength - 1, inStart, rootInorderIdx - 1);
        root.right = helper(postorder, postStart + leftSubLength, postEnd - 1, rootInorderIdx + 1, inEnd);

        return root;
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
