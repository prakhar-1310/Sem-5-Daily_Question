class Solution {
    private static final int MAX = 1002;
    int cache[][] = new int[1024][1024];
    private int f(int qs[][], int i, int j, int rem) {
        if(cache[rem][j]!=MAX) return cache[rem][j];
        else return cache[rem][j]= 
            rem==0 ? j
            : j >= qs.length ? qs.length+1
            : qs[j][0] > i || qs[j][1] < i || qs[j][2] > rem ? f(qs, i, j+1, rem) 
            : Math.min(f(qs, i,j+1, rem), f(qs, i, j+1, rem-qs[j][2])); 
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = 0, maxNum = Arrays.stream(nums).max().getAsInt();
        for (int i0=0; i0<nums.length; i0++) {
          for(int i1=0;i1<= maxNum; i1++) 
            for(int j1=0;j1<= queries.length; j1++) cache[i1][j1]=MAX;
          ans = Math.max(ans, f(queries, i0, 0, nums[i0]));
        }
        return ans > queries.length ? -1 : ans;
    }
}