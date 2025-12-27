class Solution {
    public int maximumRobots(int[] charges, int[] runningCosts, long budget) {
        Deque<Integer> dq = new ArrayDeque<>();

        int n = runningCosts.length;
        int l = 0;
        int r = 0;

        long prefixSum[] = new long[n];
        prefixSum[0] = runningCosts[0];
        for(int i=1; i< n; i++) {
            prefixSum[i] = runningCosts[i] + prefixSum[i-1];
        }

        int answer = 0;

        while(r < n) {
            // we want to keep a descending order in the deque - so that the front element is the max element in the given window (See LC 239. Sliding Window Maximum)
            while(!dq.isEmpty() && charges[dq.peekLast()] < charges[r]) {
                dq.removeLast();
            }

            // expand window from the right
            dq.addLast(r);

            // if the calculated cost is going out of bounds shrink the window from the left
            while(!dq.isEmpty() && getCost(l, r, prefixSum, dq, charges) > budget) {
                if(dq.peekFirst() <= l) dq.removeFirst();
                l++;
            }

            answer = Math.max(answer, r - l + 1);
            r++;
        }

        return answer;
    }

    private long getCost(int l, int r, long prefixSum[], Deque<Integer> dq, int charges[]) {
        long prev = l == 0 ? 0 : prefixSum[l-1];

        return charges[dq.peekFirst()] + (r - l +1) * (prefixSum[r] - prev);
    }
}