class Solution {
    long mod = 1000000007;
    public int distinctSubseqII(String s) {
        long dp[] = new long[s.length()];
        Arrays.fill(dp,-1);
        int prev[] = new int[s.length()];
        int last[] = new int[26];
        Arrays.fill(last, -1);

        for(int i=0; i<s.length();i++){
            int idx = s.charAt(i)-'a';
            prev[i]=last[idx];
            last[idx]=i;
        }

        return (int)((helper(s.length()-1, s, dp, prev)-1+mod)%mod);
    }

    public long helper(int i, String s, long dp[], int prev[]){
        if(i<0){
            return 1;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        long ans = 2*helper(i-1, s, dp, prev);

        if(prev[i]!=-1){
            ans-=helper(prev[i]-1, s, dp, prev);
        }

        return dp[i]=(ans+mod)%mod;
    }

    
}