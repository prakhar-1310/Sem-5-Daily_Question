class Solution {
    public int countBinarySubstrings(String s) {
        int curr = 1;
        int prev = 0;
        int ans =0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                curr++;
            }
            else{
                ans+=Math.min(prev,curr);
                prev = curr;
                curr=1;
            }
        }
        ans+=Math.min(prev,curr);

        return ans;
    }
}