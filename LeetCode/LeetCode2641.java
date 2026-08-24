import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode2641 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(2);

        System.out.println(new LeetCode2641().replaceValueInTreee(root));
        for (List<Integer> l : levelOrder(root)) {
            System.out.println(l);
        }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    TreeNode replaceValueInTree(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, root);
        getParents(root, map);

        Map<TreeNode, Integer> original = new HashMap<>();
        getOriginal(root, original);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int level = q.size();
            Set<TreeNode> set = new HashSet<>();
            Map<TreeNode, Integer> vals = new HashMap<>();
            int total = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                TreeNode par = map.get(node);
                set.add(par);
                vals.putIfAbsent(par, 0);
                total += original.get(node);

                vals.put(par, vals.get(par) + original.get(node));

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            for (TreeNode n : set) {
                vals.put(n, total - vals.get(n));
            }

            for (TreeNode n : set) {
                if (n.left != null) {
                    n.left.val = vals.get(n);
                }

                if (n.right != null) {
                    n.right.val = vals.get(n);
                }
            }
        }

        root.val = 0;
        return root;
    }

    private void getOriginal(TreeNode root, Map<TreeNode, Integer> original) {
        if (root == null) {
            return;
        }

        original.put(root, root.val);

        getOriginal(root.left, original);
        getOriginal(root.right, original);
    }

    private void getParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parents.put(root.left, root);
        }

        if (root.right != null) {
            parents.put(root.right, root);
        }

        getParents(root.left, parents);
        getParents(root.right, parents);
    }

    TreeNode replaceValueInTreee(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        root.val = 0;

        while (!q.isEmpty()) {
            int level = q.size();
            List<TreeNode> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                list.add(node);
                if (node.left != null) {
                    sum += node.left.val;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    sum += node.right.val;
                    q.offer(node.right);
                }
            }
            for (TreeNode n : list) {
                int sibling = 0;
                if (n.left != null)
                    sibling += n.left.val;
                if (n.right != null)
                    sibling += n.right.val;

                if (n.left != null) {
                    n.left.val = sum - sibling;
                }
                if (n.right != null) {
                    n.right.val = sum - sibling;
                }
            }
        }
        return root;
    }

    static class TreeNode {
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
