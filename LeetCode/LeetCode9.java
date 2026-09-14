import java.util.Arrays;

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        String s = x + "";

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            if (cl != cr) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindromee(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int[] digits = new int[10];
            Arrays.fill(digits, -1);
            int num = x;
            int i = 9;
            while (num > 0) {
                digits[i] = num % 10;
                num /= 10;
                i--;
            }
            int l;
            int r = 9;
            if (digits[0] != -1) {
                l = 0;
            } else {
                for (int n : digits) {
                    if (n == -1) {
                        break;
                    }
                    i++;
                }
                l = ++i;
            }

            while (l < r) {
                if (digits[l] != digits[r]) {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }
    }

    public boolean isPalindromeee(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindromee(121));
    }
}
