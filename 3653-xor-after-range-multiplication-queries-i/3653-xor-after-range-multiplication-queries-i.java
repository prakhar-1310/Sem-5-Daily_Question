class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int q[] : queries){
            int l=q[0];
            int r=q[1];
            int k=q[2];
            int v=q[3];

            for(int idx=l; idx<=r;idx+=k){
                nums[idx]=(int)((1L*nums[idx]*v)%1000000007);
            }
        }

        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor^=nums[i];
        }

        return xor;
    }
}