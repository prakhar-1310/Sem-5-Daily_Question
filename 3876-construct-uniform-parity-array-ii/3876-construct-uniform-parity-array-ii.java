class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int st = nums1[0];
        if(st%2==0){
            for(int i : nums1){
                if(i%2!=0)return false;
            }
        }
        return true;
    }
}