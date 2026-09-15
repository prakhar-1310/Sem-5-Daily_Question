class Solution {
    public int maxPalindromes(String s, int k) {
        if(k==1)return s.length();
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(0,s,k, dp);
    }

    public int helper(int idx, String s, int k, int dp[]){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];
        int ans=0;

        ans = helper(idx+1, s, k, dp); //skip
        
        for(int i=idx+k-1;i<s.length();i++){
            int opt=0;
            if(check(s, idx, i)){
                opt=1+helper(i+1, s, k, dp);
            }

            ans = Math.max(ans, opt);
        }

        return dp[idx]=ans;
    }

    public boolean check(String s, int i, int j){
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