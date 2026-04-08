package DSA.pepcoding.Linked_List;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        LinkedList ll =  new LinkedList();
        ll.addLast(45);
        ll.addLast(15);
        ll.addLast(48);
        ll.addLast(12);
        ll.addLast(32);
        ll.mergeSort(ll.head, ll.tail).display();
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

        public Node mid(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2) {
            LinkedList sortedList = new LinkedList();
            Node p1 = l1.head;
            Node p2 = l2.head;
            
            while(p1 != null && p2 != null) {
                if(p1.data <= p2.data) {
                    sortedList.addLast(p1.data);
                    p1 = p1.next;
                } else {
                    sortedList.addLast(p2.data);
                    p2 = p2.next;
                }
            }

            while(p1 != null) {
                sortedList.addLast(p1.data);
                p1 = p1.next;
            }

            while(p2 != null) {
                sortedList.addLast(p2.data);
                p2 = p2.next;
            }
            
            return sortedList;
        }

        public LinkedList mergeSort(Node head, Node tail) {
            if (head == null) {
                return new LinkedList();
            }

            if (head == tail) {
                LinkedList list = new LinkedList();
                list.addLast(head.data);
                return list;
            }

            Node mid =  mid(head, tail);
            LinkedList firstHalf = mergeSort(head, mid);
            LinkedList secondHalf = mergeSort(mid.next, tail);

            LinkedList sortedList = LinkedList.mergeTwoSortedList(firstHalf, secondHalf);
            return sortedList;
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
