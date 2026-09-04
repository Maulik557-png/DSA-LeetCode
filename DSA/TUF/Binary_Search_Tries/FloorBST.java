package DSA.TUF.Binary_Search_Tries;

public class FloorBST {
    public int findMaxFork(Node root, int k) {
        Node node = root;
        int floor = -1;

        while (node != null) {
            if (node.data == k) {
                return node.data;
            }

            if (k > node.data) {
                floor = node.data;
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return floor;
    }
}
