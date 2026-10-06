class Solution {
    public int minAddToMakeValid(String s) {
        int tot=0;
        int ans=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                tot++;
            }
            else{
                tot--;
            }

            if(tot<0){
                ans+=Math.abs(tot-0);
                tot=0;
            }
        }

        return ans+Math.abs(tot-0);

        
    }
}