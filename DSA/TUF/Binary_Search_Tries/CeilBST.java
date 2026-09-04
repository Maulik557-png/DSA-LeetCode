package DSA.TUF.Binary_Search_Tries;

public class CeilBST {
    public int findCeil(Node root, int x) {
        Node node = root;
        int ceil = -1;

        while (node != null) {
            if (node.data == x) {
                return node.data;
            }

            if (node.data < x) {
                node = node.right;
            } else {
                ceil = node.data;
                node = node.left;
            }
        }

        return ceil;
    }
}
