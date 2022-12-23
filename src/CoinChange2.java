import java.util.Arrays;

class Solution91900o {

    // todo
    public int change(int amount, int[] coins) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i >= coin) {
                    boolean done = false;
                    for (int k = 0; k < j; ++k) {
                        if (coin % coins[k] == 0) {
                            dp[i] += Integer.compare(dp[i - coin], 0);
                            done = true;
                            break;
                        }
                    }
                    if (!done) {
                        dp[i] += dp[i - coin];
                    }
                }
            }
        }
        return dp[amount];
    }
}