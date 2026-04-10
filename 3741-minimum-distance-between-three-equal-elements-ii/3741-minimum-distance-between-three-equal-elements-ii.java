class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>>map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int mini = Integer.MAX_VALUE;

        for(int i : map.keySet()){
            if(map.get(i).size()<3)continue;

            for(int j=2;j<map.get(i).size();j++){
                int a = map.get(i).get(j-2);
                int b = map.get(i).get(j-1);
                int c = map.get(i).get(j);

                int sum = b-a + c-b + c-a;
                mini = Math.min(mini, sum);
            }
        }

        return mini==Integer.MAX_VALUE ? -1 : mini;
    }
}