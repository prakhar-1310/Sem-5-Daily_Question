class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        if(nums2.length%2!=0){
            for(int i : nums1){
                ans^=i;
            }
        }

        if(nums1.length%2!=0){
            for(int i : nums2){
                ans^=i;
            }
        }

        return ans;

        
    }
}