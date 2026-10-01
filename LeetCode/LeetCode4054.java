import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LeetCode4054 {
    // Appraoch 1
    public long shadowPairsss(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> st = new ArrayList<>();
        long res = 0;

        for (int j = 0; j < n; j++) {
            int cur = nums[j];

            if (!st.isEmpty()) {
                int low = 0;
                int high = st.size();
                while (low < high) {
                    int mid = (low + high) >>> 1;
                    if (st.get(mid) < cur)
                        low = mid + 1;
                    else
                        high = mid;
                }
                res += low;
            }

            while (!st.isEmpty() && st.get(st.size() - 1) > cur) {
                st.remove(st.size() - 1);
            }
            st.add(cur);
        }
        return res;
    }

    // Approach 2 - TLE
    public long shadowPairs(int[] nums) {
        List<List<Integer>> larger = new ArrayList<>();
        List<List<Integer>> smaller = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            larger.add(new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    larger.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            smaller.add(new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    smaller.get(i).add(j);
                }
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j : larger.get(i)) {
                boolean failed = false;
                for (int k : smaller.get(i)) {
                    if (k >= j) {
                        break;
                    }

                    failed = true;
                    break;
                }

                if (!failed) {
                    res++;
                }
            }
        }

        return res;
    }

    // Approach 3
    public long shadowPairss(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nextSmaller[i] = stack.peek();
            }

            stack.push(i);
        }

        MergeSortTree tree = new MergeSortTree(nums);
        long res = 0;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = nextSmaller[i] - 1;

            if (left <= right) {
                res += tree.countGreater(left, right, nums[i]);
            }
        }

        return res;
    }

    static class MergeSortTree {
        private final int[][] tree;
        private final int n;

        MergeSortTree(int[] nums) {
            this.n = nums.length;
            tree = new int[4 * n][];
            build(1, 0, n - 1, nums);
        }

        private void build(int node, int left, int right, int[] nums) {
            if (left == right) {
                tree[node] = new int[] { nums[left] };
                return;
            }

            int mid = left + (right - left) / 2;
            build(node * 2, left, mid, nums);
            build(node * 2 + 1, mid + 1, right, nums);

            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        private int[] merge(int[] a, int[] b) {
            int[] result = new int[a.length + b.length];

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    result[k++] = a[i++];
                } else {
                    result[k++] = b[j++];
                }
            }

            while (i < a.length) {
                result[k++] = a[i++];
            }

            while (j < b.length) {
                result[k++] = b[j++];
            }

            return result;
        }

        public int countGreater(int left, int right, int value) {
            return countGreater(1, 0, n - 1, left, right, value);
        }

        private int countGreater(
                int node,
                int start,
                int end,
                int left,
                int right,
                int value) {
            if (end < left || start > right) {
                return 0;
            }

            if (left <= start && end <= right) {
                int index = upperBound(tree[node], value);
                return tree[node].length - index;
            }

            int mid = start + (end - start) / 2;

            int countLeft = countGreater(
                    node * 2,
                    start,
                    mid,
                    left,
                    right,
                    value);

            int countRight = countGreater(
                    node * 2 + 1,
                    mid + 1,
                    end,
                    left,
                    right,
                    value);

            return countLeft + countRight;
        }

        private int upperBound(int[] arr, int target) {
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
