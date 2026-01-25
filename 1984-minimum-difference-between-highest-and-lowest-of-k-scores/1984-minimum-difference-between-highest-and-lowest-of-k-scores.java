class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int max=nums[k-1];
        int min= nums[0];
        ans= max-min;

        for (int i=k;i<nums.length;i++){
            max=nums[i];
            min=nums[i-k+1];
            ans = Math.min(ans,max-min);
        }
        return ans;      
    }
}