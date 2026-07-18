class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return helper(nums[0], nums[nums.length-1]);
    }

    public int helper(int a, int b){
        if(b==0){
            return a;
        }

        return helper(b,a%b);
    }
}