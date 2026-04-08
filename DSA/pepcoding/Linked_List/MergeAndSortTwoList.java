package DSA.pepcoding.Linked_List;

public class MergeAndSortTwoList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);
        
        LinkedList l2 =  new LinkedList();
        l2.addLast(12);
        l2.addLast(15);
        l2.addLast(32);
        l2.addLast(45);
        l2.addLast(48);

        LinkedList sortedList = LinkedList.mergeAndSort(l1, l2);
        sortedList.display();
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

        public static LinkedList mergeAndSort(LinkedList l1, LinkedList l2) {
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
