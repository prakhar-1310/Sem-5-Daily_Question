class Solution {
    public int numDecodings(String s) {
        int dp[] = new int [s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }

    public int helper(String ques, int idx, int dp[]){
        if(idx>ques.length()){
            return 0;
        }

        if(idx==ques.length()){
            return 1;
        }

        if(ques.charAt(idx)=='0'){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ans = helper(ques,idx+1,dp); // one character
        
        if(ques.length()>idx+1){ // two character
            int num = Integer.parseInt(ques.substring(idx,idx+2));
            if(num<=26){
                ans+=helper(ques,idx+2,dp);
            }
        }
        return dp[idx]=ans;
    }
}