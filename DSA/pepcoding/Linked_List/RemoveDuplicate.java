package DSA.pepcoding.Linked_List;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(21);
        ll.addLast(21);
        ll.removeDuplicates();
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

        public void removeDuplicates() {
            LinkedList list = new LinkedList();

            while(this.size > 0) {
                int f = this.getFirst();
                this.removeFirst();

                if(list.size == 0 || f != list.tail.data) list.addLast(f);
            }

            this.head = list.head;
            this.tail = list.tail;
            this.size = list.size;
        }   

        // Time: O(n^2), Space: O(1)
        public void removeDuplicatesNoBuffer() {
            Node current = head;
            while (current != null) {
                Node runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        if (runner.next == tail) tail = runner;
                        runner.next = runner.next.next;
                        size--;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }

        // Time: O(n), Space: O(n)
        public LinkedList removeDuplicatesUsingSet() {
            Set<Integer> set = new HashSet<>();
            LinkedList list = new LinkedList();
            Node temp = head;

            while (temp != null) {
                set.add(temp.data);
                temp = temp.next;
            }

            for (int n : set)
                list.addLast(n);
            return list;
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
