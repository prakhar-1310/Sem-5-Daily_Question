class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int result[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int move = nums[i]%nums.length;
            
            int idx = i+move;
            if(idx<0){
                idx = nums.length+idx;
            }
            idx = idx%(nums.length);
            result[i]=nums[idx];
        }

        return result;
    }
}