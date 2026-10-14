class Solution {
    public long subArrayRanges(int[] nums) {
        long tot=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int max=nums[i];
            int min = nums[i];
            for(int j=i;j<n;j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                tot = tot + Math.abs(max-min);
            }
        }

        return tot;
    }
}