import java.util.ArrayList;
import java.util.List;

public class LeetCode129 {
    List<Integer> list;
    StringBuilder sb;

    public int sumNumbers(TreeNode root) {
        sb = new StringBuilder();
        list = new ArrayList<>();
        helper(root);
        int res = 0;
        for (int n : list) {
            res += n;
        }
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(Integer.valueOf(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        helper(root.left);
        helper(root.right);

        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode129 l = new LeetCode129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(l.sumNumbers(root));
    }

    public static class TreeNode {
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
