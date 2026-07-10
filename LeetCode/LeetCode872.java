import java.util.ArrayList;
import java.util.List;

public class LeetCode872 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);


        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inOrder(root1, l1);
        inOrder(root2, l2);

        return l1.equals(l2);
    }

    public static void inOrder(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        inOrder(root.left, leaves);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        inOrder(root.right, leaves);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
