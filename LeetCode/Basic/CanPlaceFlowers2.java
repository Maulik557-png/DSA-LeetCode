public class CanPlaceFlowers2 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int left;
        int right;

        for(int i = 0; i < flowerbed.length && n > 0; i++)  {
            if(flowerbed[i] == 0)   {
                left = (i == 0) ? 0 : flowerbed[i-1];
                right = (i == (flowerbed.length - 1)) ? 0 : flowerbed[i+1];
                
                if(left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] fb = {1,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(fb, n));
    }
}
