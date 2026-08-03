import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {
    List<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        inOrder(node.left);
        inOrder(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
