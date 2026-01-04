class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }

        return helper(0,s.length()-1,s,dp);
    }

    public int helper(int i, int j, String s, int dp[][]){
        if(i>=s.length() || j<0 || i>j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=0;

        if(i==j){
            ans =  1;
        }

        else if(s.charAt(i)==s.charAt(j)){
            ans= 2+ helper(i+1,j-1,s,dp);
        }
        else{
            int opt1 = helper(i+1,j,s,dp);
            int opt2 = helper(i,j-1,s,dp);
            ans = Math.max(opt1,opt2);
        }

        return dp[i][j]= ans;
    }
}