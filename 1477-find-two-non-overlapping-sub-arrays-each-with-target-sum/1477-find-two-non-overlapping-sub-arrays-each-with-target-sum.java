class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int end[] = new int[n];
        Arrays.fill(end, -1);

        int left=0;
        int sum=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];

            while(sum>=target){
                if(sum==target){
                    end[left]=right;
                }
                sum-=arr[left++];
            }
        }

        int dp[][] = new int[n][3];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }

        int ans = helper(0, end, 0, dp);
        return ans==Integer.MAX_VALUE/2 ? -1 : ans;

    }

    public int helper(int idx, int end[], int cnt, int dp[][]){
        if(cnt==2)return 0;

        if(idx>=end.length)return Integer.MAX_VALUE/2;
        if(dp[idx][cnt]!=-1)return dp[idx][cnt];

        // skip
        int opt1 = helper(idx+1, end, cnt, dp);

        // take(end here)
        if(end[idx]==-1)return dp[idx][cnt]=opt1;
        int fir = end[idx]-idx+1;
        int sec = helper(end[idx]+1, end, cnt+1, dp);
        
        if(sec==Integer.MAX_VALUE/2)return dp[idx][cnt]=opt1;;

        return dp[idx][cnt] = Math.min(opt1, fir+sec);
    }
}