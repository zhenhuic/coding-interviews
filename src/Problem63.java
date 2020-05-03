/**
 * 股票的最大利润
 */
public class Problem63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int max = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                if (prices[i] - buy > max)
                    max = prices[i] - buy;
            }
        }
        return max;
    }
}
