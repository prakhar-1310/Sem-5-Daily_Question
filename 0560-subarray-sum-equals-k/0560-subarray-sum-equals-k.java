class Solution {
    public int subarraySum(int[] nums, int k) {
        long sum=0;
        int ans=0;
        HashMap<Long , Integer> map = new HashMap<>();
        map.put((long)(0),1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
            
        }

        return ans;
    }
}