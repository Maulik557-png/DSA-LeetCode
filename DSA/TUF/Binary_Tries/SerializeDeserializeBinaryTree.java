package DSA.TUF.Binary_Tries;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        SerializeDeserializeBinaryTree t = new SerializeDeserializeBinaryTree();
        String data = t.serialize(root);
        Node node = t.deserialize(data);
        System.out.println("Serialize result: " + data);
        System.out.println("De-serialize result: ");
        t.traverse(node);
    }

    StringBuilder sb;

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        sb = new StringBuilder();
        preOrder(root);

        String data = sb.toString();
        return data;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("#,") || data.trim().isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        if (values.length == 0) {
            return null;
        }

        int[] idx = new int[1];
        Node node = buildTree(values, idx);

        return node;
    }

    public Node buildTree(String[] values, int[] idx) {
        if (idx[0] >= values.length) {
            return null;
        }
        String val = values[idx[0]];
        idx[0]++;

        if (val.equals("#")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));

        node.left = buildTree(values, idx);
        node.right = buildTree(values, idx);

        return node;
    }

    public void preOrder(Node root) {
        if (root == null) {
            sb.append('#').append(",");
            return;
        }

        sb.append(root.data).append(",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        traverse(root.left);
        traverse(root.right);
    }
}
