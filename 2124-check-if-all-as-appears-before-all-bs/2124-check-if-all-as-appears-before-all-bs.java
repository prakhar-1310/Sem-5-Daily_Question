class Solution {
    public boolean checkString(String s) {
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)-s.charAt(i-1)<0){
                return false;
            }
        }
        return true;
    }
}