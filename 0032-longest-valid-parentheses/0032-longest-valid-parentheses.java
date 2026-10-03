class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        int ans=0;
        Stack<Integer>st = new Stack<>();
        st.push(-1);
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else{
                st.pop();

                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    ans = Math.max(ans, i-st.peek());
                }
            }
        }

        return ans;
    }
}