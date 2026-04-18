public class LeetCode141 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(0);
        ll.addLast(-4);
        ll.tail.next =  ll.head.next; // form a cycle
        System.out.println(hasCycle(ll.head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        System.gc();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // public static boolean hasCycle(ListNode head) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode temp = head;
    //     while(temp != null) {
    //         if(!set.add(temp)) {
    //             return true;
    //         }
    //         temp = temp.next;
    //     }
    //     return false;
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
