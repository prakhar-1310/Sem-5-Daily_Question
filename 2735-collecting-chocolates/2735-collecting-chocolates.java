class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long min[] = new long[n];
        long tot = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            min[i]=nums[i];
        }

        for(int turn=0;turn<n;turn++){
            long cost = 1L*turn*x;

            for(int i=0;i<n;i++){
                min[i]=Math.min(min[i], nums[(i+turn)%n]);
                cost+=min[i];
            }
            tot = Math.min(tot, cost);
        }

        return tot;
    }
}