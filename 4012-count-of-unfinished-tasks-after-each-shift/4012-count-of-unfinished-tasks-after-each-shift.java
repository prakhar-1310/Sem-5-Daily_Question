class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;

        long pref[] = new long[n];
        pref[0]=tasks[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+tasks[i];
        }

        int ans[] = new int[shifts.length];
        long prev=0;
        for(int i=0;i<shifts.length;i++){
            if(prev+shifts[i]>=pref[n-1]){
                ans[i]=0;
                prev=0;
            }
            else{
                prev+=shifts[i];
                int idx = helper(prev, pref);

                ans[i] = n-1-idx;

            }
        }

        return ans;
    }

    public int helper(long sum, long arr[]){
        int ans=-1;
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]<=sum){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
    }
}