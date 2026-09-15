class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k==1)return n;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        boolean palin[][] = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1])){
                    palin[i][j]=true;
                }
            }
        }
        return helper(0,s,k, dp, palin);
    }

    public int helper(int idx, String s, int k, int dp[], boolean palin[][]){
        if(idx>=s.length()){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];
        int ans=0;

        ans = helper(idx+1, s, k, dp, palin); //skip
        
        for(int i=idx+k-1;i<s.length();i++){
            int opt=0;
            if(palin[idx][i]){
                opt=1+helper(i+1, s, k, dp, palin);
            }

            ans = Math.max(ans, opt);
        }

        return dp[idx]=ans;
    }
}