class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int low =0;
        int high = nums.size()/2;
        int ans =low;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(check(nums,mid)){
                ans= mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }

    public boolean check(List<Integer>list, int k){
        int count=1;
        int prev=0;
        for(int i=1;i<list.size();i++){
            if(list.get(i)>list.get(i-1)){
                count++;
            }
            else{
                prev= count;
                count=1;
            }
            if(count>=2*k || Math.min(count,prev)>=k){
                return true;
            }
        }

        return false;
    }
}