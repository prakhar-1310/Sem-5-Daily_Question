class Solution {
    public long countIntersectingIntervals(int[][] intervals){
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });

        long tot=0;

        for(int i=0;i<n;i++){
            int low = i+1;
            int high = n-1;
            int ans=n;
            while(low<=high){
                int mid = low + (high-low)/2;

                if(intervals[mid][0]>intervals[i][1]){
                    ans = mid;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            tot+=ans-1-i;
        }

        return tot;
    }
}