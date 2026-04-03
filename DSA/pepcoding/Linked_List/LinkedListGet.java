package DSA.pepcoding.Linked_List;

public class LinkedListGet {
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
