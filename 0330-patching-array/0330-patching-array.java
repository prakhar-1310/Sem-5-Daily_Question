class Solution {
    public int minPatches(int[] nums, int n) {
        int patch=0;
        int maxReach = 0;
        int idx=0;
        while(maxReach<n){
            if(idx<nums.length && nums[idx]<=maxReach+1){
                maxReach+=nums[idx];
                idx++;
            }
            else{
                maxReach+=maxReach+1;
                patch++;
            }
        }
        return patch;
    
    }
}