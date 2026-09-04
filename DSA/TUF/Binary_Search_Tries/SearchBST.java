package DSA.TUF.Binary_Search_Tries;

public class SearchBST {
    public Node searchBST(Node root, int val) {
        Node node = root;

        while (node != null) {
            if (node.data == val) {
                return node;
            }

            if (val > node.data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }
}
