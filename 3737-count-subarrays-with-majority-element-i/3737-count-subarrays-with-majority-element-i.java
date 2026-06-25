class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int cnt=0;
        
        for(int i=0;i<nums.length;i++){
            int tcnt=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target){
                    tcnt++;
                }
                int len = j-i+1;
                if(len/2<tcnt){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}