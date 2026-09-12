import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

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

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) {
            return null;
        }

        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootInorderIdx = inorderMap.get(rootVal);
        int leftSubLength = rootInorderIdx - inStart;

        root.left = helper(postorder, postStart, postStart + leftSubLength - 1, inStart, rootInorderIdx - 1);
        root.right = helper(postorder, postStart + leftSubLength, postEnd - 1, rootInorderIdx + 1, inEnd);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }
}
