package DSA.pepcoding.Linked_List;

public class OddEvenList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(4);
        ll.addLast(8);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(7);
        ll.addLast(4);
        ll.oddEven();
        System.out.println(ll.size());
        // ll.display();
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

        public void oddEven() {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while (this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();
                if (val % 2 == 0)
                    even.addLast(val);
                else
                    odd.addLast(val);
            }

            if (odd.size > 0 && even.size > 0) {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if(odd.size > 0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if(even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        // public LinkedList oddEven() {
        // LinkedList odd = new LinkedList();
        // LinkedList even = new LinkedList();

        // Node temp = head;
        // while(temp != null) {
        // int val = temp.data;
        // if(val % 2 == 0) even.addLast(val);
        // else odd.addLast(val);
        // temp = temp.next;
        // }

        // odd.tail.next = even.head;
        // return odd;
        // }

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
