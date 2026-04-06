package DSA.pepcoding.Linked_List;

public class MidOfLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.addLast(70);
        ll.addLast(80);
        ll.addLast(90);
        ll.addLast(100);
        ll.addLast(110);
        ll.addLast(120);
        System.out.println(ll.getMid());
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

        public int getMid() {
            if (isEmpty()) {
                System.out.println("Linked List is Empty");
                return -1;
            } else if(size == 1 || size == 2) {
                return head.data;
            }

            Node slow = head;
            Node fast = head;

            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
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
