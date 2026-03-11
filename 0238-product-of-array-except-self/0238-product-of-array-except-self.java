class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pref[] = new int [nums.length];
        int suf[] = new int[nums.length];

        pref[0] = 1;
        suf[suf.length-1] = 1;

        for(int i=0;i<nums.length-1;i++){
            pref[i+1] =  pref[i]*nums[i];
        }

        for(int i=nums.length-1;i>0;i--){
            suf[i-1]=suf[i]*nums[i];
        }

        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = pref[i]*suf[i];
        }

        return ans;
    }
}