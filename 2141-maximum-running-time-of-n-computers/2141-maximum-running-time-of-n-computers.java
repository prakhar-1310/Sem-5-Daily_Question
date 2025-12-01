class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long low =0;
        long high=0;
        for(int i : batteries){
            high+=i;
        }
        long ans= 0;
        while(low<=high){
            long mid  =  low +  (high-low)/2;

            if(isItPossible(batteries, mid, n)){
                ans = mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
    }

    public boolean isItPossible(int arr[], long  mid, int n){
        long total=0;
        for(int i: arr){
            total+=Math.min(i,mid);
        }


        return mid*n <=total;
    }
}