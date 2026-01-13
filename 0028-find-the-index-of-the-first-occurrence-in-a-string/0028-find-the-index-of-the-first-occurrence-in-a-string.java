class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        int len = needle.length();
        for(int i=0;i<haystack.length();i++){
            for(int j=len+i;j<=haystack.length();j++){
                if(haystack.substring(i,j).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}