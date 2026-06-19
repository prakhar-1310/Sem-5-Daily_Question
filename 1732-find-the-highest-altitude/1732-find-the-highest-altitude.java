class Solution {
    public int largestAltitude(int[] gain) {
        int alt =0;
        int ans = alt;
        for (int i=0;i<gain.length;i++){
            alt+=gain[i];
            ans =Math.max(ans,alt);
        }
        return ans;
    }
}