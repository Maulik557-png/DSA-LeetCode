public class LeetCode4022 {
    public static int kthDigit(long k) {
        if (k <= 9) {
            return (int) k;
        }

        long rem = k;
        long range = 0;

        long c1 = 1;
        long c2 = 1;

        while (rem > range) {
            range = 9 * c1 * c2;

            if (rem > range) {
                rem -= range;
            } else {
                // k lies in this range
                break;
            }

            c1++;
            c2 *= 10;
        }

        long digs = c1 * 10;
        long offset = (rem - 1) / digs;
        long first = c2 / 10;
        long block = first + offset;
        long pos = (rem - 1) % digs;
        long numOff = pos / c1;
        long digOff = pos % c1;
        long number;

        number = block % 2 == 0 ? block * 10 + numOff : block * 10 + 9 - numOff;

        String s = String.valueOf(number);
        return s.charAt((int) digOff) - '0';
    }

    public static void main(String[] args) {
        long k = Long.MAX_VALUE;
        System.out.println(kthDigit(k));
    }
}
