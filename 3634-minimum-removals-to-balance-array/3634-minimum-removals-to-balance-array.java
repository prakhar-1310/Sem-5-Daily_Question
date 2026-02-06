class Solution {
    public int minRemoval(int[] nums, int k) {

        
        Arrays.sort(nums);
        int n = nums.length;
        int ans = n;
        int j=0;
        for(int i=0;i<n;i++){
            while(j<n && nums[j]<=(long)nums[i]*k){
                j++;
            }
            int size = j-i;
            ans=Math.min(ans,n-size);
        }
        return ans;
    }
}