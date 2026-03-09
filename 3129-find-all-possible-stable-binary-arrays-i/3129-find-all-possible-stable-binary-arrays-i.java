class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][] = new int[zero+1][one+1][3];
        // for(int i[][] : dp){
        //     for(int j[] : i){
        //         Arrays.fill(-1);
        //     }
        // }
        return helper(zero,one,limit,2,dp);
    }

    public int helper(int z, int o, int l, int prev, int dp[][][]){
        if(z==0 && o==0){
            return 1;
        }

        if(dp[z][o][prev]!=0){
            return dp[z][o][prev];
        }

        long ans=0;
        if(prev != 0){ // explore zero
            for(int len=1;len<=Math.min(l,z);len++){
                ans = (ans +  helper(z-len,o,l,0,dp))%1000000007;
            }
        }
        if(prev != 1){ // explore one
            for(int len=1;len<=Math.min(l,o);len++){
                ans = (ans +  helper(z,o-len,l,1,dp))%1000000007;
            }
        }

        return dp[z][o][prev]=(int)ans;
        
    }
}