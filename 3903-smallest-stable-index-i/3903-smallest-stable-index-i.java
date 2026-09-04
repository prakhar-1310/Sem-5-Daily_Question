class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxPre[] = new int[nums.length];
        int minSuf[] = new int[nums.length];

        maxPre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            maxPre[i]=Math.max(maxPre[i-1], nums[i]);
        }

        minSuf[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            minSuf[i]=Math.min(minSuf[i+1], nums[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(maxPre[i]-minSuf[i]<=k)return i;
        }

        return -1;
    }
}