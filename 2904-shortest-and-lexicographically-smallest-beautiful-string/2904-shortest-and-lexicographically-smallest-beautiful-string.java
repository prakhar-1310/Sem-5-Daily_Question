class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int left=0;
        int len=Integer.MAX_VALUE;
        int cnt=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='1'){
                cnt++;
            }
            while(cnt==k){
                if(ans==""){
                    ans=s.substring(left, right+1);
                }
                if(len==(right-left+1) && ans.compareTo(s.substring(left, right+1))>0){
                    ans=s.substring(left,right+1);
                }
                else if(len>(right-left+1)){
                    len=right-left+1;
                    
                    ans = (s.substring(left,right+1));
                }

                if(s.charAt(left)=='1'){
                    cnt--;
                }

                left++;
            }
        }

        return ans;
    }
}