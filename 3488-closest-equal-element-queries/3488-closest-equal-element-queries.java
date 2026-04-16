class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer>ans = new ArrayList<>();

        HashMap<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }


        for(int i=0;i<queries.length;i++){
            int q = queries[i];
            int n = nums[q];

            if(map.get(n).size()==1){
                ans.add(-1);
                continue;
            }

            int mini=Integer.MAX_VALUE;

            for(int idx : map.get(n)){
                if(idx==q)continue;

                int min = Math.min(Math.abs(q-idx), nums.length-Math.abs(q-idx));

                mini = Math.min(mini,min);
            }

            ans.add(mini);
        }

        return ans;
    }
}