class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int F=0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            F+=nums[i]*i;
            sum+=nums[i];
        }

        int max = F;
        for(int i=1;i<n;i++){
            int nextF = F + sum - nums[n-i]*n;
            max = Math.max(max, nextF);
            F = nextF;
        }

        return max;
    }
}