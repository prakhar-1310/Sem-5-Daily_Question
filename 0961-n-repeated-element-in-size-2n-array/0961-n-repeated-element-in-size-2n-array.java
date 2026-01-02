class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        Arrays.sort(nums);
        int count=1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev==nums[i]){
                count++;
                if(count==n){
                    return prev;
                }
            }
            else{
                prev = nums[i];
                count=1;
            }
        }

        return prev;
    }
}