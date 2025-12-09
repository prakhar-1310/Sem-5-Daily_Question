class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer>map_left = new HashMap<>();
        HashMap<Integer,Integer>map_right = new HashMap<>();
        int mod = 1000000007;
        for(int i :nums){
            map_right.put(i,map_right.getOrDefault(i,0)+1);
        }
        long count=0;

        map_right.put(nums[0],map_right.get(nums[0])-1);
        if(map_right.get(nums[0])==0){
            map_right.remove(nums[0]);
        }
        for(int i=1;i<nums.length;i++){
            map_left.put(nums[i-1],map_left.getOrDefault(nums[i-1],0)+1);
            map_right.put(nums[i],map_right.get(nums[i])-1);
            if(map_right.get(nums[i])==0){
                map_right.remove(nums[i]);
            }
            int n = 2*nums[i];
            if(map_left.containsKey(n) && map_right.containsKey(n)){
                long temp=(1L*map_left.get(n)*map_right.get(n))%mod;
                count = (count+temp)%mod;
            }
        }

        return (int)count;
    }
}