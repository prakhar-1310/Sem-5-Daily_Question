class Solution {
    public boolean doesAliceWin(String s) {
        int count=0;
        for(char i : s.toCharArray()){
            if(i=='a' || i=='e' || i=='o' || i=='u' || i=='i'){
                count++;
            }
        }
        if(count==0){
            return false;
        }
        
        return true;
    }
}