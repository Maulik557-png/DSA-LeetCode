import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode350 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);

        for (int i : res) {
            System.out.println(i);
        }
    }

    // public static int[] intersect(int[] nums1, int[] nums2) {
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
        
    //     int i = 0, j = 0;
    //     List<Integer> list = new ArrayList<>();
        
    //     while (i < nums1.length && j < nums2.length) {
    //         if (nums1[i] == nums2[j]) {
    //             list.add(nums1[i]);
    //             i++;
    //             j++;
    //         } 
    //         else if (nums1[i] < nums2[j])  i++;
    //         else  j++;
    //     }
        
    //     int[] res = new int[list.size()];
    //     for (int k = 0; k < list.size(); k++) {
    //         res[k] = list.get(k);
    //     }
    //     return res;
        
    //     // return list.stream()
    //     //             .mapToInt(n -> n)
    //     //             .toArray();
    // }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums1)  map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)  res[i] = result.get(i);
        return res;
    }
}
