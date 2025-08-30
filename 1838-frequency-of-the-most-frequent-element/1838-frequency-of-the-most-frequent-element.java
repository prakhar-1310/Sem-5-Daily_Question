class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans=1;
        long inc =0 ;
        for(int right=1;right<nums.length;right++){
            inc += (long)(nums[right]-nums[right-1])*(right-left);

            while(inc>k){
                inc-=(long) (nums[right]-nums[left]);
                left++;
            }

            ans = Math.max(ans,right-left+1);
        }
        

        return ans;
    }

    
}