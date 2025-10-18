class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int max = num+k;
            int min = num-k;

            int val = prev+1;
            if(val<min){
                val = min;
            }
            if(val<=max){
                prev = val;
                count++;
            }
        }

        return count;
    }
}