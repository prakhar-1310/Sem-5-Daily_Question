class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_sum=kanadesMax(nums);
        int min_sum = kanadesMin(nums);
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int circularSum=sum-min_sum;
        if (max_sum>0){
            return Math.max(circularSum,max_sum);
        }
        else{
            return max_sum;
        }
        
    }
    public static int kanadesMax(int arr[]){
        int n =arr.length;
        int sum=0;
        int ans = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            ans = Math.max(ans,sum);
            if (sum<0){
                sum=0;
            }
        }
        return ans;
    }
    public static int kanadesMin(int arr[]){
        int n =arr.length;
        int sum=0;
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            ans = Math.min(ans,sum);
            if (sum>0){
                sum=0;
            }
        }
        return ans;
    }
}