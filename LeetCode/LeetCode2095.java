public class LeetCode2095 {
    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        } else if (head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
