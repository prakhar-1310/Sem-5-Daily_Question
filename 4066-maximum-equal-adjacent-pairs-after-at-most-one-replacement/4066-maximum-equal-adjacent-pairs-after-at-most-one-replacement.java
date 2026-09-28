class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<String, Integer>map = new HashMap<>();

        int cnt=0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                cnt++;
            }
            else{
                int a = nums[i];
                int b = nums[i+1];
                String s ="";
                if(a<b){
                    s = a+","+b;
                }
                else{
                    s = b+","+a;
                }

                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        int max=0;
        for(String s : map.keySet()){
            max=Math.max(max, map.get(s));
        }

        return max+cnt;
    }
}