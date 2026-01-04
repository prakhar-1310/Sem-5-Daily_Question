class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;

        for(int i[] : restrictions){
            int idx = i[0];
            int val = i[1];
            ans[idx] = val;
        }

        for(int i=1;i<n;i++){
            int dif = diff[i-1];
            ans[i] = Math.min(ans[i-1]+dif,ans[i]);
        }

        for(int i=n-2;i>=0;i--){
            int dif = diff[i];
            ans[i] =  Math.min(ans[i+1] + dif, ans[i]);
        }

        int max=0;
        for(int i : ans){
            max = Math.max(i,max);
        }

        return max;
        
    }
}