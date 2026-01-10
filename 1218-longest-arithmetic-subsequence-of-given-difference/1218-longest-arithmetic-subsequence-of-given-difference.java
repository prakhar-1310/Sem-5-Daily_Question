class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer>map = new HashMap<>();// val,count
        int ans=1;
        for(int i : arr){
            int count= map.getOrDefault(i-difference,0);
            map.put(i,count+1);
            ans=Math.max(ans,count+1);
        }
        return ans;
    }
}