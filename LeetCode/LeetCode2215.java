import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode2215 {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        List<List<Integer>> list = findDifference(nums1, nums2);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1)
            set1.add(n);
        for (int n : nums2)
            set2.add(n);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n)) {
                l1.add(n);
            }
        }

        for (int n : set2) {
            if (!set1.contains(n)) {
                l2.add(n);
            }
        }

        return Arrays.asList(l1, l2);
    }
}
