class Solution {
    public boolean isTrionic(int[] nums) {
        int idx=0;
        int cnt=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                idx=i;
                break;
            }
            else{
                cnt=1;
            }
        }
        if(cnt==0){
            return false;
        }
        cnt=0;
        for(int i=idx;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
            else{
                cnt=1;
            }
        }
        if(cnt==0){
            return false;
        }
        cnt=0;
        for(int i=idx;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
            else{
                cnt=1;
            }
        }
        if(cnt==0 ){
            return false;
        }

        return true;
    }
}