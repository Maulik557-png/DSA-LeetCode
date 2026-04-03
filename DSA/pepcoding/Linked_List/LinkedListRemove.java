package DSA.pepcoding.Linked_List;

public class LinkedListRemove {
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
}
