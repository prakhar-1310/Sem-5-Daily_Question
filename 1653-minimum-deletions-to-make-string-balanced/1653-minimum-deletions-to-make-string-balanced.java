class Solution {
    public int minimumDeletions(String s) {
        int del =0;
        int countB=0;
        for(char c : s.toCharArray()){
            if(c=='a'){
                del = Math.min(del+1, countB); // del+1 is for deleting 'a'
                                                // countB for deleting 'b'
            }
            else{
                countB++;
            }
        }

        return del;
    }
}