package DSA.pepcoding.Linked_List;

public class LinkedListAdd {
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
            if (size == 0) {
                node.data = val;
                node.next = null;
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int removeFirst() {
            int val;
            if(size == 0) {
                System.out.println("Linked list is empty");
                val = -1;
            } else if(size == 1) {
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
        
        public void display() {
            if(size == 0) System.out.println("Linked list is empty");
            Node node = new Node();
            node = head;
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.removeFirst();
        ll.addLast(20);
        ll.removeFirst();
        ll.addLast(30);
        ll.removeFirst();
        ll.addLast(40);
        ll.removeFirst();
        ll.addLast(50);
        ll.removeFirst();
        ll.addLast(60);
        ll.removeFirst();
        ll.addLast(70);
        ll.removeFirst();
        ll.addLast(80);
        ll.removeFirst();
        ll.addLast(90);
        ll.removeFirst();
        ll.addLast(100);
        ll.display();
    }
}

