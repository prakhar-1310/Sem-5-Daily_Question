class Solution {
    public boolean rotateString(String s, String goal) {
        int idx=-1;
        for(int i=goal.length()-1;i>=0;i--){
            if(goal.charAt(i)==s.charAt(0)){
                idx=i;
                break;
            }
        }
        if(idx==-1 || s.length()!=goal.length())return false;

        for(int i=1;i<s.length();i++){
            idx=(idx+1)%goal.length();
            if(s.charAt(i)!=goal.charAt(idx)){
                return false;
            }
        }

        return true;
    }
}