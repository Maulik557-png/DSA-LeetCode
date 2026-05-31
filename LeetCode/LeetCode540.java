public class LeetCode540 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        if (nums[l] != nums[l + 1]) {
            return nums[0];
        }
        if (nums[r] != nums[r - 1]) {
            return nums[r];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] != nums[mid - 1] &&
                    nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (nums[mid] == nums[mid - 1]) {

                int pairStart = mid - 1;

                if (pairStart % 2 == 0) {
                    l = mid + 1;
                } else {
                    r = mid - 2;
                }

            } else {

                int pairStart = mid;

                if (pairStart % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    // public static int singleNonDuplicate(int[] nums) {
    //     if(nums.length == 1) {
    //         return nums[0];
    //     }
    //     int l = 0;
    //     int r = nums.length - 1;

    //     if(nums[l] != nums[l + 1]) {
    //         return nums[l];
    //     } else if(nums[r] != nums[r - 1]) {
    //         return nums[r];
    //     }

    //     while(l <= r) {
    //         int mid = l + (r - l) / 2;

    //         if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
    //             return nums[mid];
    //         }

    //         if(nums[mid] == nums[mid - 1]) {
    //             if((mid - l + 1) % 2 == 0) {
    //                 l = mid + 1;
    //             } else {
    //                 r = mid - 1;
    //             }
    //         } else {
    //             if((r - mid + 1) % 2 == 0) {
    //                 r = mid - 1;
    //             } else {
    //                 l = mid + 1;
    //             }
    //         }
    //     }
    //     return 0;
    // }
}
