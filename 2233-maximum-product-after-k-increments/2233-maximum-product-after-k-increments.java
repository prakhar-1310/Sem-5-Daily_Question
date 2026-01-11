class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();

        for(int i : nums){
            pq.add(i);
        }

        while(k>0){
            int a = pq.poll();
            a++;
            k--;
            pq.add(a);
        }

        long ans =1;

        while(!pq.isEmpty()){
            long m = pq.poll();
            ans = (ans*m)%1000000007;
        }

        return (int)ans;
    }
}