class Solution {
    public int change(int amount, int[] coins) {
        return coinBU(coins,amount);
    }
    public static int coinBU(int coin[], int amount) {
		int dp[][] = new int[coin.length+1][amount+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<dp.length;i++) {
			for(int am = 1;am<dp[0].length;am++) {
				int inc =0;
				int exc =0;
				if(am>=coin[i-1]) {
					inc = dp[i][am-coin[i-1]]; 
				}
				exc = dp[i-1][am];
				dp[i][am]= inc + exc;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}