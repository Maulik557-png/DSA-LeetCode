package DSA.pepcoding.Linked_List;

public class KReverseInLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(7);
        ll.addLast(4);
        ll.kReverse(4);
        ll.display();
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

        public void addFirst(int val) {
            Node node = new Node();
            node.data = val;
            node.next = head;
            head = node;
            if (isEmpty()) {
                tail = node;
            }
            size++;
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

        public int getFirst() {
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            }
            return head.data;
        }

        public int removeFirst() {
            int val;
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            } else if (size == 1) {
                val = head.data;
                head = null;
                tail = null;
                size--;
            } else {
                val = head.data;
                head = head.next;
                size--;
            }
            return val;
        }

        // Time: O(n), Spcae: O(1)
        public void kReverse(int k) {
            LinkedList prev = null;
            while(this.size > 0) {
                LinkedList curr = new LinkedList();

                if(this.size >= k) {   
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val); 
                    }
                } else {
                    int originalSize = this.size();
                    for (int i = 0; i < originalSize; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }

                if(prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }
            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
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
