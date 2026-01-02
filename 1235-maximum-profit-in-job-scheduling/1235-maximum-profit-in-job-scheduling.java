class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int jobs[][] = new int[startTime.length][3];
        for(int i=0;i<jobs.length;i++){
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }

        Arrays.sort(jobs,(a,b)->{
            return a[0]-b[0];
        });

        //int dp[][] = new int[jobs.length][jobs[jobs.length-1][1]+1];
        // dp array of this means endTime = 10^9 means MLE
        // for(int i[] : dp){
        //     Arrays.fill(i,-1);
        // }

        int dp[] = new int[jobs.length];
        Arrays.fill(dp,-1);

        return helper(0,jobs,dp);
    }

    public int helper(int i, int jobs[][], int dp[]){
        if(i>=jobs.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        //inc{
        int next = binarySearch(i,jobs);
        int inc = helper(next,jobs,dp)+jobs[i][2];
        
        // exc
        int exc = helper(i+1,jobs,dp);

        return dp[i]=Math.max(inc,exc);
    }

    public int binarySearch(int i, int jobs[][]){
        int low=i+1;
        int high = jobs.length-1;
        int ans = jobs.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(jobs[mid][0]>=jobs[i][1]){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}