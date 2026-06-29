class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt=0;
        for(String i : patterns){
            if(word.contains(i)){
                cnt++;
            }
        }
        return cnt;
    }
}