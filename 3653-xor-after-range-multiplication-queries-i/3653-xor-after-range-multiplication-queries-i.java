class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        int arr[][] = queries;

        for(int q[] : arr){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            for(int idx = l;idx<=r;idx+=k){
                nums[idx]= (int)((1L * nums[idx] * v)%mod);
            }
        }
        int xor =0;
        for(int i : nums){
            xor^=i;
        }

        return xor;
    }
}