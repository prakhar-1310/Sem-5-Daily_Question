class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        for(int i =0;i<nums1.length; i++){
            int temp = helper(i, nums2, nums1[i]);
            max = Math.max(max, temp-i);
        }
        return max;
    }

    public int helper(int i, int arr[], int tar){
        int low=i;
        int high=arr.length-1;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=tar){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
    }
}