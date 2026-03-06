class Solution {
    public boolean checkOnesSegment(String s) {
        char prev = s.charAt(0);
        int cnt=0;
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(prev!=ch){
                cnt++;
            }
            prev=ch;
        }

        return cnt<2;
    }
}