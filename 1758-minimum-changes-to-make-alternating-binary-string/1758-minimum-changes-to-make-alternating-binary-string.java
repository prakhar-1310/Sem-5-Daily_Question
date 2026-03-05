class Solution {
    public int minOperations(String s) {
        int opt1 = helper('0',s);
        int opt2 = helper('1',s);
        return Math.min(opt1,opt2);
    }

    public int helper(char prev, String s){
        int cnt=0;
        for(char ch: s.toCharArray()){
            if(ch==prev){
                if(ch=='1'){
                    prev='0';
                }
                else{
                    prev='1';
                }
                cnt++;
            }
            else{
                prev=ch;
            }
        }
        return cnt;
    }
}