class Solution {
    public String longestPalindrome(String s) {
        int maxL = 0;
        String ans = "";

        for(int i=0;i<s.length();i++){
            String odd = helper(s, i, i);
            String even = helper(s, i, i+1);

            if(maxL<odd.length()){
                maxL = odd.length();
                ans = odd;
            }

            if(maxL<even.length()){
                maxL = even.length();
                ans = even;
            }
        }

        return ans;
    }

    public String helper(String s, int left, int right ){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}