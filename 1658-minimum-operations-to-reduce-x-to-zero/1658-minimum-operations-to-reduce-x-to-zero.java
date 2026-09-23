class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tot=0;
        for(int i : nums){
            tot+=i;
        }

        int req = tot-x;

        int ans=-1;

        int left=0;
        int sum=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];

            while(sum>req && left<=right){
                sum-=nums[left++];
            }

            if(sum==req){
                ans = Math.max(ans, right-left+1);
            }
        }

        return ans==-1?-1:n-ans;
    }
}