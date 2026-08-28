class Solution {
    public boolean isIdealPermutation(int[] nums) {
        if(nums.length<3)return true;
        int cnt=0;
        int left = nums[1];
        int prevleft=nums[0];
        for(int j=2;j<nums.length;j++){
            if(prevleft>nums[j])return false;
            prevleft = Math.max(prevleft,left);
            left=nums[j];
        }
        
        return true;
    }
}