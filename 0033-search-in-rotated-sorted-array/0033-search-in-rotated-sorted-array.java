class Solution {
    public int search(int[] nums, int target) {
        return helper(nums,0,nums.length-1,target);
    }
    public int helper(int nums[], int i, int j, int target){
        if(i>j){
            return -1;
        }
        int mid = (i+j)/2;
        if(target==nums[mid]){
            return mid;
        }
        int left = helper(nums,i,mid-1,target);
        int right = helper(nums,mid+1,j,target);
        if(left!=-1){
            return left;
        }
        if(right != -1){
            return right;
        }
        return -1;
    }
}