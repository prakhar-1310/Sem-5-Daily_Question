class Solution {
    // binary search to get lower bound element
    public int binarySearch(int[][] events, int target){
        int ans = events.length; // default
        int l = 0;
        int r = ans-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(events[mid][0]>target){
                ans = mid; // store this ans
                r = mid-1; // even search for more better ans
            }else{
                l = mid+1;
            }
        }
        return ans; // required index
    }
    public int solve(int[][] events, int i, int k, Integer[][] dp){
        if(i>=events.length || k==0){
            return 0; // when 2 selected or all events covered
        }

        if(dp[i][k]!=null) return dp[i][k]; // optimization

        int nextValidIndex = binarySearch(events, events[i][1]); // thats the optimization

        // 2 - Options
        int take = events[i][2] + solve(events, nextValidIndex, k-1, dp);
        int not_take = solve(events, i + 1, k, dp);
        int sum = Math.max(take, not_take); // go with better ans

        return dp[i][k] = sum; // ans
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]); // sort on the basis of start time
        Integer[][] dp = new Integer[events.length][3]; // for memoization
        return solve(events, 0, 2, dp);
    }
}