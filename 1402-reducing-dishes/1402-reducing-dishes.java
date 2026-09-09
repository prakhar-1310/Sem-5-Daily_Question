class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int dp[][] = new int[satisfaction.length][satisfaction.length+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }
        return helper(0, satisfaction, 1, dp);
    }

    public int helper(int i, int arr[], int cnt, int dp[][]){
        if(i>=arr.length){
            return 0;
        }

        if(dp[i][cnt]!=-1)return dp[i][cnt];

        int ans=0;

        // take
        int opt1 = arr[i]*cnt + helper(i+1, arr, cnt+1, dp);

        // skip

        int opt2 = helper(i+1, arr, cnt, dp);

        ans = Math.max(opt1, opt2);

        return dp[i][cnt]=ans;
    }
}