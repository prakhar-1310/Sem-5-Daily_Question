class Solution {
    public void sortColors(int[] nums) {
        int st=0;
        int mid=0;
        int ed=nums.length-1;
        while(mid<=ed){
            if(nums[mid]==2){
                helper(nums,mid,ed);
                ed--;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                helper(nums,st,mid);
                st++;
                mid++;
            }
           
        }
        // return nums;
        
    }
    public void helper(int nums[], int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}