package DSA.TUF.Binary_Tries;

public class IsSymmetric {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(9);
        root.right.right = new Node(7);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);

        System.out.println(isSymmetric(root));
    }



    private static boolean isSymmetric(Node root) {

        int data = root.data;
        System.out.println(data);

        return false;
    }
}
