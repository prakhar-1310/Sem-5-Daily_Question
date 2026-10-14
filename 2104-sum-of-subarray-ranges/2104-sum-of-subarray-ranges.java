class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long mnSum = 0;
        long mxSum = 0;
        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i == n || nums[st.peek()] <= nums[i])){
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long cnt = (long)(mid-left) * (i-mid);
                mxSum += (long)cnt*nums[mid];
            }
            st.push(i);
        }
        st.clear();
        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])){
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long cnt = (long)(mid-left) * (i-mid);
                mnSum += (long)cnt*nums[mid];
            }
            st.push(i);
        }
        return mxSum-mnSum;
    }
}