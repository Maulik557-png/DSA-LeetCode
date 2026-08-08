import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode2385 {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = getParents(root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode target = getNode(root, start);

        int time = 0;
        q.offer(target);
        while (!q.isEmpty()) {
            int level = q.size();
            int fl = 0;
            for (int i = 0; i < level; i++) {
                TreeNode n = q.poll();
                visited.add(n);

                TreeNode parent = map.get(n);
                if (parent != null && !visited.contains(parent)) {
                    fl = 1;
                    visited.add(parent);
                    q.offer(parent);
                }

                if (n.left != null && !visited.contains(n.left)) {
                    fl = 1;
                    visited.add(n.left);
                    q.offer(n.left);
                }

                if (n.right != null && !visited.contains(n.right)) {
                    fl = 1;
                    visited.add(n.right);
                    q.offer(n.right);
                }
            }
            if (fl == 1) {
                time++;
            }
        }

        return time;
    }

    public Map<TreeNode, TreeNode> getParents(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    map.put(node.left, node);
                    q.offer(node.left);
                }

                if (node.right != null) {
                    map.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }

        return map;
    }

    public TreeNode getNode(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }

        TreeNode leftResult = getNode(root.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        return getNode(root.right, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }
    }
}
