class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int max=0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            max = Math.max(max,map.get(i));
        }
        
        int ans=0;
        for (int i : map.values()){
            if(i==max){
                ans+=i;
            }
        }

        return ans;
        
    }
}