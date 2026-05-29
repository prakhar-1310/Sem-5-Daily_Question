class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            
            int sum=0;
            while(temp>0){
                sum+=temp%10;
                temp/=10;
            }

            ans = Math.min(ans, sum);
        }

        return ans;
    }
}