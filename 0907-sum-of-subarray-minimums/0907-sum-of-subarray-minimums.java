class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long mnSum = 0;
        long mod = 1000000007;

        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])){
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right=i;
                long cnt = (long)(mid-left) * (right-mid);
                long temp = (cnt*arr[mid])%mod;
                mnSum = (mnSum+temp)%mod;
            }
            st.push(i);
        }
        return (int)mnSum;
    }
}