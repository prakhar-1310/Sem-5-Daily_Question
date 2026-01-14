class Solution {
    public long perfectPairs(int[] nums) {
        //HashSet<Integer> set = new HashSet<>();
        long count=0;
        for(int i=0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int l=0;
        int r=0;
        int len = nums.length;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];

            while(l<len && nums[l] < (num+1)/2){
                l++;
            }

            while(r<len && nums[r]<=2*num){
                r++;
            }

            int s = Math.max(l,i+1);
            if(s<r){
                count+=(r-s);
            }
        }
        return count;
    }
}