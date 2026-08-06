package DSA.TUF.Binary_Tries;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConstructBinaryTree1 {
    public static void main(String[] args) {
        int[] pre = { 3, 9, 20, 15, 7 };
        int[] in = { 9, 3, 15, 20, 7 };

        Node node = buildTree1(pre, in);

        for (List<Integer> l : traverse(node)) {
            System.out.println(l);
        }
    }

    public static Node buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
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

        int[] newPreOrderLeft = Arrays.copyOfRange(preorder, 1, 1 + leftSubLength);
        int[] newPreOrderRight = Arrays.copyOfRange(preorder, leftSubLength + 1, preorder.length);

        root.left = buildTree1(newPreOrderLeft, newInOrderLeft);
        root.right = buildTree1(newPreOrderRight, newInOrderRight);

        return root;
    }

    private static Map<Integer, Integer> inorderMap;

    public static Node buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }

        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static Node helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);

        int rootInorderIdx = inorderMap.get(rootVal);

        int leftSubLength = rootInorderIdx - inStart;

        root.left = helper(preorder, preStart + 1, preStart + leftSubLength, inStart, rootInorderIdx - 1);
        root.right = helper(preorder, preStart + leftSubLength + 1, preEnd, rootInorderIdx + 1, inEnd);

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
