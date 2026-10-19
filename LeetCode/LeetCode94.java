import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {

        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
