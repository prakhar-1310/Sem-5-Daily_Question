class Solution {
    int pref[];
    public int stoneGameVIII(int[] stones) {
        int dp[] = new int[stones.length];
        Arrays.fill(dp,1000000000);
        pref = new int[stones.length+1];
        for(int i=0;i<stones.length;i++){
            pref[i+1]=pref[i]+stones[i];
        }
        return helper(1, stones, dp);
        
    }

    public int helper(int ind, int arr[], int dp[]){
        if(ind==arr.length-1){
            return pref[arr.length];
        }

        if(dp[ind]!=1000000000){
            return dp[ind];
        }

        int ans = Integer.MIN_VALUE;
        
        int next = helper(ind+1, arr,dp);
        ans=Math.max(pref[ind+1]-next, next);
        

        return dp[ind]=ans;
    }
}