class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, pivot);
        int n = nums.length;
        int left=0;
        int right=n-1;
        for(int i=0, j=n-1; i<n; i++, j--){
            if(nums[i]<pivot){
                ans[left++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[right--]=nums[j];
            }
        }

        return ans;
    }
}