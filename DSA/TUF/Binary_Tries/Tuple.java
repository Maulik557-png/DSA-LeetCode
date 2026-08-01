package DSA.TUF.Binary_Tries;

public class Tuple {
        public Node node;
        public int vertical;
        public int level;

        public Tuple(Node node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }