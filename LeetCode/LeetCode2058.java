public class LeetCode2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        int min = Integer.MAX_VALUE;
        int firstIdx = -1;
        int prevIdx = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        int currIdx = 1;

        while (curr.next != null) {
            ListNode next = curr.next;

            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if (isMax || isMin) {
                if (firstIdx == -1) {
                    firstIdx = currIdx;
                } else {
                    min = Math.min(min, currIdx - prevIdx);
                }
                prevIdx = currIdx;
            }

            prev = curr;
            curr = next;
            currIdx++;
        }

        if (firstIdx == prevIdx) {
            return new int[] { -1, -1 };
        }

        int max = prevIdx - firstIdx;

        return new int[] { min, max };
    }

    public int[] nodesBetweenCriticalPointss(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        ListNode node = head;
        int size = 0;
        while (node != null && node.next != null) {
            size++;
            node = node.next;
        }

        boolean[] isCritical = new boolean[size + 1];
        int i = 0;
        while (next != null) {
            if (prev == null) {
                prev = curr;
                curr = next;
                next = next.next;
            } else {
                int c = curr.val;
                int p = prev.val;
                int n = next.val;

                isCritical[i] = isLocalMin(c, p, n) || isLocalMax(c, p, n);

                prev = curr;
                curr = next;
                next = next.next;
            }
            i++;
        }

        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= size; k++) {
            if (isCritical[k]) {
                if (first == -1) {
                    first = k;
                } else {
                    min = Math.min(min, k - last);
                }
                last = k;
            }
        }

        if (first == -1 || first == last) {
            return new int[] { -1, -1 };
        }

        int max = last - first;

        return new int[] { min, max };
    }

    public boolean isLocalMin(int val, int prev, int next) {
        return val < prev && val < next;
    }

    public boolean isLocalMax(int val, int prev, int next) {
        return val > prev && val > next;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}
