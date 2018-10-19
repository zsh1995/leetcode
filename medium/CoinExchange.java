import java.util.Arrays;

/**
 * CoinExchange
 */
public class CoinExchange {

    /**
     * status(i,j) 前 i 个硬币，最少取多少个能够达到j。 status(i,j) = min( status(i, j - val(i)) +
     * 1, status(i - 1,j) )
     */
    public int coinChange(int[] coins, int amount) {
        int status[] = new int[amout + 1];
        Arrays.fill(status, Integer.MAX_VALUE);
        status[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int crtCoin = coins[i];
            for (int j = crtCoin; j <= amout; j++) {
                if (status[j - crtCoin] == Integer.MAX_VALUE) {
                    if (crtCoin == amount)
                        status[j] = 1;
                } else {
                    status[j] = Math.min(status[j - crtCoin] + 1, status[j]);
                }
            }
        }
        return status[amount] == Integer.MAX_VALUE ? -1 : status[amount];
    }

}