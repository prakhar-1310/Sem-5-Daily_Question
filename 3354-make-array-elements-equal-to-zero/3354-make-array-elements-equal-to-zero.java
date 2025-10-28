class Solution {
    public int countValidSelections(int[] nums) {
        int pref[] = new int[nums.length];
        int suf[] = new int[nums.length];

        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i] = nums[i]+pref[i-1];
        }

        suf[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suf[i]=suf[i+1]+nums[i];
        }

        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && pref[i]==suf[i]){
                sum+=2;
            }
            else if(nums[i]==0 && Math.abs(pref[i]-suf[i])==1){
                sum+=1;
            }
        }

        return sum;
    }
}