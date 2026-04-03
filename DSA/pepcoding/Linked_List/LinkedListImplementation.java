package DSA.pepcoding.Linked_List;

public class LinkedListImplementation {
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

        public void addAt(int index, int val) {
            if (index < 0 || index > size) {
                System.out.println("IndexOutOfBoundsException");
            } else if (index == 0) {
                addFirst(val);
            } else if (index == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        public int getFirst() {
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            }
            return head.data;
        }

        public int getLast() {
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            }
            return tail.data;
        }

        public int getAt(int index) {
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            } else if (index >= size || index < 0) {
                System.out.println("IndexOutOfBoundsException");
                return -1;
            } else if (index == 0) {
                return head.data;
            } else if (index == size - 1) {
                return tail.data;
            }  else {
                Node node = head;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
                return node.data;
            }
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

        public int removeLast() {
            int val;
            if (isEmpty()) {
                System.out.println("Linked list is empty");
                return -1;
            } else if (size == 1) {
                val = tail.data;
                head = null;
                tail = null;
                size--;
            } else {
                val = tail.data;
                Node node = head;
                for (int i = 0; i < size - 2; i++) {
                    node = node.next;
                }
                tail = node;
                node.next = null;
                size--;
            }
            return val;
        }

        public int removeAt(int index) {
            int val;
            if (index < 0 || index >= size) {
                System.out.println("IndexOutOfBoundsException");
                return -1;
            } else if (index == 0) {
                return removeFirst();
            } else if(index == size - 1) {
                return removeLast();
            } else {
                Node node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                val = node.next.data;
                node.next =  node.next.next;
                size--;
            }
            return val;
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
        ll.removeFirst();
        ll.removeLast();
        ll.display();
        System.out.println("=========");
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getAt(3));
        ll.removeAt(3);
        ll.display();
    }
}
