class Solution {
    int n;
    int dp[][];
    public int minOperations(int[] nums, int sum) {
        n= nums.length;
        dp = new int[n][sum+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        int ans = helper(0, sum, nums);

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int i, int sum, int arr[]){
        if(sum==0)return 0;
        if(i>=n) return Integer.MAX_VALUE;
        
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }


        int opr=0;

        int curr = arr[i];
        int ans = Integer.MAX_VALUE;

        while(curr>0){
            int opr2=0;
            int curr2 = curr;
            while(curr2<=sum){
                int temp = helper(i+1, sum-curr2, arr);
                if(temp!=Integer.MAX_VALUE){
                    ans = Math.min(ans, opr+opr2+temp);
                }

                curr2*=2;
                opr2++;
            }
            opr++;
            curr/=2;
        }

        ans =Math.min(ans, helper(i+1, sum, arr));

        return dp[i][sum]=ans;
    }
}