package DSA.pepcoding.Linked_List;

public class KthElementFromEnd {
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
        System.out.println(ll.kthElement(ll.size));
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

        // private Node getNodeAt(int index) {
        //     Node node = head;
        //     for (int i = 0; i < index; i++) {
        //         node = node.next;
        //     }
        //     return node;
        // }

        // public void reverseDI() {
        //     int l = 0;
        //     int r = size - 1;

        //     while (l < r) {
        //         Node left = getNodeAt(l);
        //         Node right = getNodeAt(r);
        //         int temp = left.data;
        //         left.data = right.data;
        //         right.data = temp;
        //         l++;
        //         r--;
        //     }
        // }

        // public int kthElement(int k) {
        //     reverseDI();            
        //     int val = getNodeAt(k).data;
        //     reverseDI();
        //     return val;
        // }

        public int kthElement(int k) {
            if (k < 0 || k >= size) {
                System.out.println("IndexOutOfBoundsException");
                return -1;
            }
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
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
