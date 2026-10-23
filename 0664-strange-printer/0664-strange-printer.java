class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        return helper(s, 0, n-1, dp);
    }

    public int helper(String s, int l, int r, int dp[][]){
        if(l>=s.length()){
            return 0;
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }

        if(l==r){
            return 1;
        }

        int i=l;
        while(i<=r && s.charAt(i)==s.charAt(l)){
            i++;
        }
        if(i>r){
            return 1;
        }

        // using opt1
        int opt1 = 1 + helper(s, i, r, dp);

        // using opt2
        int opt2 = Integer.MAX_VALUE;
        for(int j=i+1;j<=r;j++){
            if(s.charAt(l)==s.charAt(j)){
                int temp = helper(s,i, j-1, dp) + helper(s,j,r, dp);
                opt2 = Math.min(opt2, temp);
            }
        }

        return dp[l][r]=Math.min(opt1, opt2);
    }
}