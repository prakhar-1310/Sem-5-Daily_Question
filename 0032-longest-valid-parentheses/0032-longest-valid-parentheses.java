class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            int op=0;
            int cl=0;
            if(n-i<=ans)return ans;
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='('){
                    op++;
                }
                else{
                    cl++;
                }

                if(cl>op){
                    break;
                }else if(op-cl>n-j)break;

                if(op==cl){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return ans;
    }
}