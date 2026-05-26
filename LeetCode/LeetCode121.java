public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    // public static int maxProfit(int[] prices) {
    //     int[] profit = new int[prices.length];
    //     profit[prices.length - 1] = -1;
    //     int max = prices[prices.length - 1];
    //     for (int i = profit.length - 2; i >= 0; i--) {
    //         if (max > prices[i]) {
    //             profit[i] = max;
    //         } else {
    //             profit[i] = -1;
    //         }
    //         max = Math.max(max, prices[i]);
    //     }

    //     int trade = 0;

    //     for (int i = 0; i < prices.length; i++) {
    //         if (profit[i] == -1)
    //             continue;
    //         trade = Math.max(trade, profit[i] - prices[i]);
    //     }

    //     return trade;
    // }
}
