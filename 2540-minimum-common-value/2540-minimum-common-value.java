class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i=0;i<nums2.length;i++){
            int lo = 0;
            int high=nums1.length-1;
            while (lo<=high){
                int mid = lo +(high-lo)/2;
                if (nums1[mid]==nums2[i]){
                    return nums1[mid];
                }
                else if (nums1[mid]<nums2[i]){
                    lo=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}