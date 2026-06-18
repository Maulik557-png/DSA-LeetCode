public class LeetCode2130 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(100000);

        pairSum(list.head);
    }

    public static int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        ListNode l1 = head;
        ListNode l2 = prev;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n / 2; i++) {
            res = Math.max(res, l1.data + l2.data);

            l1 = l1.next;
            l2 = l2.next;
        }

        return res;
    }

    public static class ListNode {
        int data;
        ListNode next;
    }

    public static class LinkedList {
        private ListNode head;
        private ListNode tail;
        private int size;

        LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addFirst(int val) {
            ListNode node = new ListNode();
            node.data = val;
            node.next = head;
            head = node;
            if (isEmpty()) {
                tail = node;
            }
            size++;
        }

        public void addLast(int val) {
            ListNode node = new ListNode();
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
                ListNode node = new ListNode();
                node.data = val;
                ListNode temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        public void display() {
            if (isEmpty())
                System.out.println("Linked list is empty");
            ListNode node = head;
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
