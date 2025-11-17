class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int c=0;
        int j=0;
        while (j<nums.length && nums[j]!=1){
            j++;
        }
        j++;
        for (int i=j;i<nums.length;i++){
            if (nums[i]==0){
                c++;
            }
            else if (nums[i]==1){
                if (c<k){
                    return false;
                }
                c=0;
            }
        }
        return true;
    }
}