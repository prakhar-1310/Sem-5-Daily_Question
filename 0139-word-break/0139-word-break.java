class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);//-1 means not visited
        // 1 means true;
        // 0 means false;
        return helper(s,wordDict,0,dp);
    }
    public boolean helper(String s, List<String>dict, int idx, int dp[]){
        if(idx==s.length()){
            return true;
        }
        if(dp[idx]!=-1){
            return dp[idx]==1;
        }
        for(int i = idx;i<s.length();i++){
            if(dict.contains(s.substring(idx,i+1))){
                if(helper(s,dict,i+1,dp)){
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]=0;
        return false;
    }
}