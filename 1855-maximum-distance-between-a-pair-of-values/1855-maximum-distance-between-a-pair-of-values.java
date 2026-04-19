class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int maxDis=0;

        while(i<nums1.length && j<nums2.length){
            if(i<=j && nums1[i]<=nums2[j]){
                maxDis=Math.max(maxDis,j-i);
                j++;
            }
            else{
                i++;
                if(i>j){
                    j=i;
                }
            }

        }
        return maxDis;
    }
}