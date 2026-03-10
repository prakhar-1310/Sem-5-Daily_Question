class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Double dp[][][] = new Double[n][n][k+1];
		return helper(row,column,k,dp,n);
    }

    public double helper(int cr, int cc, int k,Double dp[][][], int n) {
		if(cr<0 || cr>=n|| cc<0 || cc>=n) {
			return 0;
		}

        if(k==0) {
			return 1;
		}
		
		if(dp[cr][cc][k]!=null) {
			return dp[cr][cc][k];
		}
		
		int r[] = {2,2,1,1,-2,-2,-1,-1};
		int c[] = {1,-1,2,-2,1,-1,-2,2};
		
		double prob =0.0;
		
		for(int i=0;i<8;i++) {
			prob += helper(cr+r[i], cc+c[i], k-1,dp,n);
		}
		
		prob/=8;
		
		return dp[cr][cc][k]=prob;
	}
}