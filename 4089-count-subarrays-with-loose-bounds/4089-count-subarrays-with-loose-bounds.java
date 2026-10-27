class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left=0;
        long tot=0;
        long n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=maxK && nums[i]>=minK){
                if(left==-1){
                    left=i;
                }
            }
            if(nums[i]>maxK || nums[i]<minK){
                if(left!=-1){
                    tot+=1L*(i-left+1)*(i-left)/2;
                    left=-1;
                }
                
            }
        }

        if(left!=-1){
            tot+=1L*(n-left+1)*(n-left)/2;
        }

        return tot;
    }
}