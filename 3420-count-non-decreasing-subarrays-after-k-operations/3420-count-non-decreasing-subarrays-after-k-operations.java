class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        // we need one deque and two pointer 
        int n = nums.length;
        Deque<Node> st = new ArrayDeque<>();
        int l = n-1;
        long ans = 0;
        long cost = 0;
        for(int i=n-1;i>=0;i--){
            int cur = 1;
            while(!st.isEmpty() && st.peekLast().val < nums[i]){
                Node node = st.pollLast();
                cur+=node.freq;
                long cur_cost = (nums[i]-node.val)*node.freq;
                cost+= cur_cost;
            }
            if(!st.isEmpty() && st.peekLast().val==nums[i]){
                cur += st.peekLast().freq;
                st.pollLast();
            }
            st.addLast(new Node(nums[i],cur));

            // now check the cost is valid or not 
            while(!st.isEmpty() && cost>k){
                // untill the cost is not valid we have to reduce the last pointer
                Node node = st.pollFirst();
                int cur_cost = (node.val-nums[l--]);
                cost-=cur_cost;
                if(node.freq>1) st.addFirst(new Node(node.val,node.freq-1));
            }

            if(cost<=k) ans += (l-i+1);
        }

        return ans;
    }

    private class Node{
        int val;
        long freq;
        Node(int v,long f){
            this.val = v;
            this.freq = f;
        }
    }
}