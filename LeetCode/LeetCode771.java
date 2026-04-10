public class LeetCode771 {

    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";

        System.out.println(numJewelsInStones(j, s));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int[] arr = new int[128];
        int count = 0;

        for(char ch: stones.toCharArray())  {
            arr[ch]++;
        }

        for(int i = 0; i < jewels.length(); i++)  {
            count += arr[jewels.charAt(i)];
        }
        return count;
    }
}
