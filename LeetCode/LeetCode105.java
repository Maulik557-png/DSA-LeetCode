import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
    // My first approach
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
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

        int[] newPreOrderLeft = Arrays.copyOfRange(preorder, 1, 1 + leftSubLength);
        int[] newPreOrderRight = Arrays.copyOfRange(preorder, leftSubLength + 1, preorder.length);

        root.left = buildTree1(newPreOrderLeft, newInOrderLeft);
        root.right = buildTree1(newPreOrderRight, newInOrderRight);

        return root;
    }

    // Optimized approach
    public Map<Integer, Integer> inorderMap;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }

        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootInorderIdx = inorderMap.get(rootVal);

        int leftSubLength = rootInorderIdx - inStart;

        root.left = helper(preorder, preStart + 1, preStart + leftSubLength, inStart, rootInorderIdx - 1);
        root.right = helper(preorder, preStart + leftSubLength + 1, preEnd, rootInorderIdx + 1, inEnd);

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
