class Solution {
    public int minimumDeletions(int[] nums) {
        int minInd=0;
        int min = nums[0];
        int maxInd=0;
        int max=nums[0];
        for (int i=0;i<nums.length;i++){
            if (min>nums[i]){
                min = nums[i];
                minInd =i;
            }

            if (max<nums[i]){
                max = nums[i];
                maxInd = i;
            }
        }

        int n = nums.length;
        
        int left = Math.min(minInd, maxInd);
        int right = Math.max(minInd, maxInd);

        int opt1 = right+1;

        int opt2 = n - left ;

        int opt3 = left+1 + n-right;

        return Math.min(opt1, Math.min(opt3,opt2));
    }
}