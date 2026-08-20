import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode257 {
    List<String> list;
    Deque<Integer> q;
    StringBuilder sb;

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        q = new ArrayDeque<>();
        sb = new StringBuilder();
        helper(root);
        return list;
    }

    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            for (int n : q) {
                sb.append(n).append("->");
            }
            q.addLast(node.val);
            sb.append(q.peekLast());
            q.removeLast();
            list.add(sb.toString());
            sb = new StringBuilder();
            return;
        }

        q.addLast(node.val);

        helper(node.left);
        helper(node.right);

        q.removeLast();
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
