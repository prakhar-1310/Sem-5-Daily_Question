class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                set.add(grid[i][j]);

                for(int k=1;;k++){
                    if(i-k<0 || i+k>=m || j-k<0 || j+k>=n) break;

                    int sum = 0;

                    int r=i-k, c=j;
                    for(int t=0;t<k;t++) sum += grid[r+t][c+t];

                    r=i; c=j+k;
                    for(int t=0;t<k;t++) sum += grid[r+t][c-t];

                    r=i+k; c=j;
                    for(int t=0;t<k;t++) sum += grid[r-t][c-t];

                    r=i; c=j-k;
                    for(int t=0;t<k;t++) sum += grid[r-t][c+t];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        for(int i=0;i<=size-1;i++){
ans[i] = set.pollLast();
}

        return ans;
    }
}