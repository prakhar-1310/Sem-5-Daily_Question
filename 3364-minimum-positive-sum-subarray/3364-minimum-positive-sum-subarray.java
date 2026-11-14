class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min=Integer.MAX_VALUE;
        int n = nums.size();

        for(int len=l;len<=r;len++){
            int sum=0;
            for(int i=0;i<len;i++){
                sum+=nums.get(i);
            }

            if(sum>0){
                min = Math.min(min, sum);
            }

            for(int i=len;i<n;i++){
                sum-=nums.get(i-len);
                sum+=nums.get(i);
                if(sum>0){
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}