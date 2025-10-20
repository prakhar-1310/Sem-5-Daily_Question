class Solution {
    public int splitArray(int[] nums, int k) {
        int max =0;
        int sum=0;
        for(int i : nums){
            max = Math.max(max,i);
            sum+=i;
        }

        int low= max; // when k=nums.length
        int high = sum; // when k=1

        int ans = low;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(nums,k,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int nums[], int k, int mid){
        int count=1;
        long sum =0;
        for(int i : nums){
            if(i+sum<=mid){
                sum+=i;
            }
            else{
                count++;
                sum=i;
            }

            if(count>k){
                return false;
            }
        }
        return true;
    }
}