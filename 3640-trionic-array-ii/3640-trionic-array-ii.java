class Solution {
    public long maxSumTrionic(int[] nums) {
        long dp[][] = new long[nums.length][4];
        for(long i[] : dp){
            Arrays.fill(i,Long.MIN_VALUE);
        }
        return helper(0,nums,0,dp);
    }

    public long helper(int i, int nums[], int trend, long dp[][]){
        if(i>=nums.length){
            return trend==3?0:Long.MIN_VALUE/2;
        }
        if(dp[i][trend]!=Long.MIN_VALUE){
            return dp[i][trend];
        }
        long skip = Long.MIN_VALUE/2;
        long take = Long.MIN_VALUE/2;
        if(trend==0){
            //skip
            skip = helper(i+1,nums,0,dp);
        }
        if(trend==3){
            take=nums[i];
        }

        if(i<nums.length-1){
            int curr=nums[i];
            int next=nums[i+1];
            if(trend==0 && curr<next){
                take = curr + helper(i+1,nums,1,dp);
            }
            if(trend==1){//inc
                if(curr<next){
                    take = curr+helper(i+1,nums,1,dp);
                }
                else if(curr>next){
                    take = curr+helper(i+1,nums,2,dp);
                }
            }
            if(trend==2){//dec
                if(curr>next){
                    take = curr+helper(i+1,nums,2,dp);
                }
                else if(curr<next){
                    take = curr+helper(i+1,nums,3,dp);
                }
            }

            if(trend==3 && curr<next){
                take = curr + helper(i+1,nums,3,dp);
            }
        }

        return dp[i][trend]=Math.max(skip,take);
    }
}
