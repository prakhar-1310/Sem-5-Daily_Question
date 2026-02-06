class TreeAncestor {
    
    int dp[][];
    int m;
    int n;
    
    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.m = (int) (Math.log(n) / Math.log(2)) + 1;
        dp = new int[m][n];
        for(int i[] : dp) {
            Arrays.fill(i, -1);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[i][j] = parent[j];
                }
                else {
                    if(dp[i - 1][j] == -1) dp[i][j] = -1;
                    else dp[i][j] = dp[i - 1][dp[i - 1][j]];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int row = 0;
        while(k > 0) {
            if((k & 1) == 1) {
                if(node == -1) return -1;
                node = dp[row][node];
            }
            k >>= 1;
            row++;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */