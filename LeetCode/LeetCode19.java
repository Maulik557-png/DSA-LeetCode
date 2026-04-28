public class LeetCode19 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ListNode node = removeNthFromEnd(ll.head, 5);
        ll.size--;

        for (int i = 0; i < ll.size; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while(n > 0) {
            fast = fast.next;
            n--;
        }

        if(fast == null) {
            return head.next;
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    static class ListNode {
        int val;
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

        public void addLast(int val) {
            ListNode listNode = new ListNode();
            listNode.val = val;
            listNode.next = null;
            if (size == 0) {
                head = tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
            size++;
        }
    }
}
