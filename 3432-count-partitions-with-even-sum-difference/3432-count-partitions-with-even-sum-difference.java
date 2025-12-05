class Solution {
    public int countPartitions(int[] nums) {
        int ans=0;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int tl=0;
        for (int i=0;i<nums.length-1;i++){
            tl+=nums[i];
            int tr=sum-tl;
            if (Math.abs(tl-tr) % 2==0){
                ans++;
            }
        }
        return ans;
    }
}