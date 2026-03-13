class Solution {
    public long minNumberOfSeconds(int height, int[] workerTimes) {
        long low = 0;
        long high=0;
        long max=0;
        for(int i : workerTimes){
            max = Math.max(max,i);
        }
        long i=1;
        while(i<=height){
            high+=max*i;
            i++;
        }
        long ans = high;
        while(low<=high){
            long mid = low + (high-low)/2;

            if(isPossible(height, workerTimes, mid)){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int h, int arr[], long mid){
        long c=1;
        long curr=0;
        for(int i=0;i<arr.length;i++){
            while(h>0 && mid>=curr+c*arr[i]){
                curr+=(c*arr[i]);
                h--;
                c++;
            }
            c=1;
            curr=0;
            if(h==0){
                return true;
            }
        }
        return false;
    }
}