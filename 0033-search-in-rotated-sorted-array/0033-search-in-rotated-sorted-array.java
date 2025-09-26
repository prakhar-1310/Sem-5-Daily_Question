class Solution {
    public int search(int[] nums, int target) {
        return helper(nums,0,nums.length-1,target);
    }
    public int helper(int nums[], int i, int j, int target){
        int low = i;
        int high = j;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target<nums[mid] && target>=nums[low]){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}