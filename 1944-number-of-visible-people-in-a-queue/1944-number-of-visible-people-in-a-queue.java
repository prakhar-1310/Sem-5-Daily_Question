class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer>st = new Stack<>();
        int max = Integer.MIN_VALUE;
        int ans[] = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]<=heights[i]){
                ans[st.pop()]++;
            }
            if(!st.isEmpty()){
                ans[st.peek()]++;
            }
            st.push(i);
        }
        return ans;
    }
}