
public class LeetCode2096 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.right = new TreeNode(2);

        System.out.println(new LeetCode2096().getDirections(root, 7, 5));
    }

    // Cleaner approach
    StringBuilder sb = new StringBuilder();

    private String getDirections(TreeNode root, int s, int e) {
        TreeNode start = findNode(root, s);
        TreeNode end = findNode(root, e);

        TreeNode lca = lca(root, start, end);

        int up = count(lca, start, 0);

        for (int i = 0; i < up; i++) {
            sb.append("U");
        }

        dfs(lca, end, "");

        return sb.toString();
    }

    private int count(TreeNode root, TreeNode target, int depth) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            return depth;
        }

        int left = count(root.left, target, depth + 1);

        if (left != -1) {
            return left;
        }

        return count(root.right, target, depth + 1);
    }

    private boolean dfs(TreeNode root, TreeNode target, String direction) {
        if (root == null) {
            return false;
        }

        sb.append(direction);

        if (root == target) {
            return true;
        }

        if (dfs(root.left, target, "L") || dfs(root.right, target, "R")) {
            return true;
        }

        sb.deleteCharAt(sb.length() - 1);

        return false;
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode left = findNode(root.left, value);

        if (left != null) {
            return left;
        }

        return findNode(root.right, value);
    }

    // Raw approach
    // StringBuilder sb;

    // public String getDirections(TreeNode root, int s, int e) {
    //     TreeNode start = findNode(root, s);
    //     TreeNode end = findNode(root, e);
    //     TreeNode a = lca(root, start, end);

    //     if (a == start) {
    //         sb = new StringBuilder();
    //         boolean[] flag = new boolean[1];
    //         flag[0] = false;
    //         dfs(a.left, end, "L", flag);
    //         if (!flag[0]) {
    //             boolean[] fl = new boolean[1];
    //             fl[0] = false;
    //             sb = new StringBuilder();
    //             dfs(a.right, end, "R", fl);
    //         }
    //         return sb.toString();
    //     } else if (a == end) {
    //         int c = count(end, start, 0);
    //         sb = new StringBuilder();
    //         for (int i = 0; i < c; i++) {
    //             sb.append("U");
    //         }
    //         return sb.toString();
    //     } else {
    //         int c = count(a, start, 0);
    //         sb = new StringBuilder();
    //         for (int i = 0; i < c; i++) {
    //             sb.append("U");
    //         }
    //         String str = sb.toString();
    //         boolean[] flag = new boolean[1];
    //         flag[0] = false;
    //         dfs(a.left, end, "L", flag);
    //         if (!flag[0]) {
    //             sb = new StringBuilder();
    //             sb.append(str);
    //             dfs(a.right, end, "R", flag);
    //         }
    //         return sb.toString();
    //     }
    // }

    // public int count(TreeNode root, TreeNode dest, int curr) {
    //     if (root == null) {
    //         return -1;
    //     }

    //     if (root == dest) {
    //         return curr;
    //     }

    //     int left = count(root.left, dest, curr + 1);
    //     if (left != -1) {
    //         return left;
    //     }

    //     return count(root.right, dest, curr + 1);
    // }

    // public void dfs(TreeNode root, TreeNode node, String s, boolean[] flag) {
    //     if (root == null) {
    //         return;
    //     }

    //     sb.append(s);

    //     if (root == node) {
    //         flag[0] = true;
    //         return;
    //     }

    //     dfs(root.left, node, "L", flag);

    //     if (!flag[0]) {
    //         dfs(root.right, node, "R", flag);
    //     }

    //     if (!flag[0]) {
    //         sb.deleteCharAt(sb.length() - 1);
    //     }
    // }

    // public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null || p == root || q == root) {
    //         return root;
    //     }

    //     TreeNode left = lca(root.left, p, q);
    //     TreeNode right = lca(root.right, p, q);

    //     if (right == null) {
    //         return left;
    //     } else if (left == null) {
    //         return right;
    //     } else {
    //         return root;
    //     }
    // }

    // TreeNode findNode(TreeNode root, int value) {
    //     if (root == null) {
    //         return null;
    //     }

    //     if (root.val == value) {
    //         return root;
    //     }

    //     TreeNode found = findNode(root.left, value);
    //     if (found != null) {
    //         return found;
    //     }

    //     return findNode(root.right, value);
    // }

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
