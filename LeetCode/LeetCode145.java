import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {
    List<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        inOrder(node.right);
        list.add(node.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
