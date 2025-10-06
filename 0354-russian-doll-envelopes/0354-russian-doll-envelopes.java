class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });

        // now apply LIS on height
        int dp[][] = new int[envelopes.length][2];
        dp[0]=envelopes[0];
        int len=1;
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1]>dp[len-1][1]){
                dp[len]=envelopes[i];
                len++;
            }
            else{
                int idx = helper(dp,envelopes[i],0,len-1);
                dp[idx]=envelopes[i];
            }
        }


        

        return len;
    }

    public int helper(int arr[][], int nums[], int low, int high){
        int idx=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[1]<=arr[mid][1]){
                idx = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return idx;
    }
}