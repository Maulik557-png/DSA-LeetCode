import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = parents(root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        int distance = 0;
        q.offer(target);
        while (!q.isEmpty() && distance < k) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode n = q.poll();
                visited.add(n);

                TreeNode parent = map.get(n);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }

                if (n.left != null && !visited.contains(n.left)) {
                    visited.add(n.left);
                    q.offer(n.left);
                }

                if (n.right != null && !visited.contains(n.right)) {
                    visited.add(n.right);
                    q.offer(n.right);
                }
            }

            distance++;
        }

        List<Integer> list = new ArrayList<>();
        for (TreeNode n : q) {
            list.add(n.val);
        }

        return list;
    }

    public Map<TreeNode, TreeNode> parents(TreeNode root) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }
    }
}
