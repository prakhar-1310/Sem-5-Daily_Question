class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count=0;
        while(!isSorted(nums)){
            count++;
            int mini=Integer.MAX_VALUE;
            int idx=0;

            for(int i=0;i<nums.length-1;i++){
                int sum = nums[i]+nums[i+1];
                if(sum<mini){
                    mini=sum;
                    idx=i;
                }
            }

            int arr[] = new int[nums.length-1];
            int j=0;
            for(int i=0;i<arr.length;i++){
                if(i==idx){
                    arr[j++]=mini;
                    i++;
                }
                else{
                    arr[j++]=nums[i];
                }
            }

            nums=arr;
        }
        return count;
        
    }
    public boolean isSorted(int nums[]){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}