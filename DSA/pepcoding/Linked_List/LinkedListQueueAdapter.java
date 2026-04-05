package DSA.pepcoding.Linked_List;

public class LinkedListQueueAdapter {
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
            } else {
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
            } else if (index == size - 1) {
                return removeLast();
            } else {
                Node node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                val = node.next.data;
                node.next = node.next.next;
                size--;
            }
            return val;
        }

        private Node getNodeAt(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public void reversePI() {
            int r = size - 1;

            for (int i = size - 1; i > 0; i--) {
                getNodeAt(r).next = getNodeAt(i - 1);
                r--;
            }
            getNodeAt(0).next = null;
            Node temp = head;
            head = tail;
            tail = temp;
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

    public static class Queue {
        LinkedList ll;

        public Queue() {
            ll = new LinkedList();
        }

        public int size() {
            return ll.size();
        }

        public void enque(int val) {
            ll.addLast(val);
        }

        public int deque() {
            if (ll.isEmpty()) {
                System.out.println("Queue is underflow");
                return -1;
            } else {
                return ll.removeFirst();
            }
        }

        public int peek() {
            if (ll.isEmpty()) {
                System.out.println("Queue is underflow");
                return -1;
            } else {
                return ll.getFirst();
            }
        }

        public void display() {
            ll.display();
        }
    }

    public static void main(String[] args) {
        Queue st = new Queue();
        st.enque(10);
        st.enque(20);
        st.enque(30);
        st.enque(40);
        st.enque(50);
        st.enque(80);
        st.display();
        System.out.println("========");
        st.deque();
        st.display();
    }
}
