import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetCode993 {
    // BFS approach
    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        getParents(root, map);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            TreeNode xNode = null;
            TreeNode yNode = null;
            boolean foundX = false;
            boolean foundY = false;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();

                if (node.val == x) {
                    foundX = true;
                    xNode = node;
                }

                if (node.val == y) {
                    foundY = true;
                    yNode = node;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (foundX && foundY) {
                return map.get(xNode) != map.get(yNode);
            }
            if (foundX || foundY) {
                return false;
            }
        }
        return false;
    }

    public static void getParents(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        getParents(root.left, map);
        getParents(root.right, map);
    }

    // DFS Approach
    TreeNode xParent = null, yParent = null;
    int xDepth = -1, yDepth = -1;

    public boolean isCousin(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null)
            return;

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
        } else if (node.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        if (xParent != null && yParent != null)
            return;

        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(7);
        t.left.left.left = new TreeNode(9);
        t.left.right = new TreeNode(8);
        t.left.left.right = new TreeNode(12);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(4);
        t.right.left = new TreeNode(5);
        System.out.println(isCousins(t, 7, 4));
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
