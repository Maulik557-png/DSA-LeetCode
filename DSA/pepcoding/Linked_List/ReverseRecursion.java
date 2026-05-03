package DSA.pepcoding.Linked_List;

public class ReverseRecursion {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(7);
        ll.displayReverse();
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addLast(int val) {
            Node node = new Node();
            node.data = val;
            node.next = null;
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        private void reverseRecursive(Node node) {
            if(node == null) return;
            reverseRecursive(node.next);
            System.out.println(node.data);
        }

        public void displayReverse() {
            this.reverseRecursive(head);
        }

        public void display() {
            if (isEmpty())
                System.out.println("Linked list is empty");
            Node node = head;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
