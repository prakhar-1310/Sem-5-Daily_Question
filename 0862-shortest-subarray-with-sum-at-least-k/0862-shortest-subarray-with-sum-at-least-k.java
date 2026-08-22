class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long pref[] = new long[n+1];
        pref[0]=0;
        for(int i=0;i<n;i++){
            pref[i+1]=pref[i]+nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int ans = n+1;
        for(int i=0;i<=n;i++){
            while(!deque.isEmpty() && pref[i]-pref[deque.peekFirst()]>=k){
                ans = Math.min(ans, i-deque.pollFirst());
            }

            while(!deque.isEmpty() && pref[i]<=pref[deque.peekLast()]){
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return ans==n+1 ? -1 : ans;
    }
}