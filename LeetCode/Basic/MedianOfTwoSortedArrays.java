public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length && k < (nums1.length + nums2.length))  {
            if(nums1[i] <= nums2[j])    {
                temp[k] = nums1[i];
                i++;
            }
            else    {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length) {
            temp[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length) {
            temp[k] = nums2[j];
            j++;
            k++;
        }
        int low = 0;
        int high = temp.length - 1;

        if(temp.length % 2 == 0)    {
            int mid = (low + high)/2;
            return (temp[mid] + temp[mid + 1])/2.0;
        }
        else    {
            return temp[(temp.length)/2];
        }
    }

    public static void main(String[] args)  {
        int[] nums1 = {1,3,5,9};
        int[] nums2 = {2,6,8,11,15};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}

