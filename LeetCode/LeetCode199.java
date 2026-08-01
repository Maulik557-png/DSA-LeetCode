import java.util.ArrayList;
import java.util.List;

public class LeetCode199 {
    List<Integer> list;

    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        traverse(root, 0);
        return list;
    }

    public void traverse(TreeNode node, int l) {
        if (node == null) {
            return;
        }

        if (list.size() == l) {
            list.add(node.val);
        }

        traverse(node.right, l + 1);
        traverse(node.left, l + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
