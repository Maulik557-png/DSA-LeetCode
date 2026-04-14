public class LeetCode876 {
public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(5);
        ll.addLast(9);
        System.out.println(middleNode(ll.head).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
