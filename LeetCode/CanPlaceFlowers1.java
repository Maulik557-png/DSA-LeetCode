// **Wrong Approach**

public class CanPlaceFlowers1 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int f = 0;
        int c = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1)
                c++;
        }
        System.out.println(c);
        for (int i = 0; i < flowerbed.length - 2; i++) {
            if (flowerbed[i] == 1) {
                f++;
                if (flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
                    f++;
                }
            }
        }
        System.out.println(f);
        return (f - c == n);
    }

    public static void main(String[] args) {
        int[] fb = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(fb, n));
    }
}
