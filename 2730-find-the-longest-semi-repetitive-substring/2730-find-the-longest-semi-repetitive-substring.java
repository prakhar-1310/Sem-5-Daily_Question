class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans=0;
        int n = s.length();
        if(n<3)return n;
        int left=0;
        int curr=0;
        for(int right=1;right<n;right++){
            if(s.charAt(right)==s.charAt(right-1)){
                curr++;
            }

            while(curr>1){
                if(s.charAt(left)==s.charAt(left+1)){
                    curr--;
                }
                left++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}