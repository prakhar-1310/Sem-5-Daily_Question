class Solution {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(0, s, dp)-1;
    }

    public int helper(int idx, String s, int dp[]){
        if(idx>=s.length()){
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];
        int ans = Integer.MAX_VALUE/2;
        for(int i=idx; i<s.length(); i++){
            if(palin(s,idx,i)){
                ans =Math.min(ans, 1+ helper(i+1,s,dp));
            }
        }

        return dp[idx]=ans;
    }

    public boolean palin(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}