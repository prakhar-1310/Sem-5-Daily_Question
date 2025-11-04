class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int left=0;
        int ans[] = new int[nums.length-k+1];
        int i=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int right=0;right<nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            if(right-left+1==k){
                PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (a, b) -> {
                        if (map.get(b).equals(map.get(a)))
                            return b - a; // tie-breaker: higher value first
                        return map.get(b) - map.get(a);
                    }
                );

                pq.addAll(map.keySet());
                int sum=0;
                for(int j=0;j<x;j++){
                    int n = pq.poll();
                    sum+=n*map.get(n);
                }
                ans[i++]=sum;
            

                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
        }

        return ans;
    }
}