import java.util.SortedSet;
import java.util.TreeSet;

public class Sep03P3876 {
    public static boolean uniformArray(int[] nums1) {
        boolean flag = true;
        for (int n : nums1) {
            if (n % 2 == 0) {
                flag = !flag;
                break;
            }
        }

        if (flag) {
            return flag;
        }

        flag = true;
        for (int n : nums1) {
            if (n % 2 != 0) {
                flag = !flag;
                break;
            }
        }

        if (flag) {
            return flag;
        }

        SortedSet<Integer> odd = new TreeSet<>();
        SortedSet<Integer> even = new TreeSet<>();

        for (int n : nums1) {
            if (n % 2 == 0) {
                even.add(n);
            } else {
                odd.add(n);
            }
        }

        boolean[] isOdd = new boolean[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];

            if (odd.contains(n)) {
                isOdd[i] = true;
                continue;
            }

            if (n - odd.first() >= 1) {
                isOdd[i] = true;
            } else {
                isOdd[i] = false;
                break;
            }
        }

        flag = true;
        for (boolean f : isOdd) {
            if (!f) {
                flag = !flag;
                break;
            }
        }

        if (flag) {
            return true;
        }

        boolean[] isEven = new boolean[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];

            if (even.contains(n)) {
                isEven[i] = true;
                continue;
            }

            if (n - odd.first() >= 1) {
                isEven[i] = true;
            } else {
                isEven[i] = false;
                break;
            }
        }

        flag = true;
        for (boolean f : isEven) {
            if (!f) {
                flag = !flag;
                break;
            }
        }

        return flag;
    }

    public static boolean uniformArrayy(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int n : nums1) {
            min = Math.min(min, n);
        }

        if (min % 2 == 1) {
            return true;
        }

        for (int n : nums1) {
            if (n % 2 == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniformArrayy(new int[] { 4, 5, 7 }));
    }
}
