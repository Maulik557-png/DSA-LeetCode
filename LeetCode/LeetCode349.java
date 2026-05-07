import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        int[] res = intersection(nums1, nums2);

        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n1 : nums1)  set1.add(n1);
        for (int n2 : nums2)  if (set1.contains(n2))  set2.add(n2);

        int[] ans = new int[set2.size()];
        int i = 0;
        for (int n : set2)  ans[i++] = n;
        return ans;
    }
}