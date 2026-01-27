class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && i<nums.length-2){
                cnt++;
                nums[i]=1;
                nums[i+1]=(nums[i+1]^1);
                nums[i+2]=(nums[i+2]^1);
            }
        }
        if(nums[nums.length-3]==0 && nums[nums.length-2]==0 && nums[nums.length-1]==0){
            cnt++;
        }
        else if(nums[nums.length-3]==1 && nums[nums.length-2]==1 && nums[nums.length-1]==1){

        }
        else{
            return -1;
        }

        return cnt;
    }
}