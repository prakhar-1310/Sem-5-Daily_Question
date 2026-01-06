class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int diff[] = new int[1001];
        for(int i[] : trips){
            int st=i[1];
            int ed =i[2];
            diff[st]+=i[0];
            diff[ed]-=i[0];
        }
        int curr=0;
        for(int i : diff){
            curr+=i;
            if(curr>capacity){
                return false;
            }
        }
        return true;
    }
}