class Solution {
    public int minChanges(String s) {
        int cnt=0;
        int n = s.length();
        for(int i=0;i<n;i+=2){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if(a!=b){
                cnt++;
            }
        }

        return cnt;
    }
}