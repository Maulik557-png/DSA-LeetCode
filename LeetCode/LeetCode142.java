// import java.util.HashSet;
// import java.util.Set;

public class LeetCode142 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(0);
        ll.addLast(-4);
        ll.tail.next =  ll.head.next; // form a cycle
        System.out.println(detectCycle(ll.head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cycle = head;
                while (cycle != slow) {
                    cycle = cycle.next;
                    slow = slow.next;
                }
                return cycle;
            }
        }
        return null;
    }

    // public static ListNode detectCycle(ListNode head) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode temp = head;
    //     while (temp != null) {
    //         if (!set.add(temp)) {
    //             return temp;
    //         }
    //         temp = temp.next;
    //     }
    //     return null;
    // }

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
