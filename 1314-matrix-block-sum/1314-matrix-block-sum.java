class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=helper(Math.max(0,i-k), Math.min(n-1, i+k), Math.max(0, j-k), Math.min(m-1, j+k), mat);
            }
        }

        return ans;
    }

    public int helper(int i, int x, int j, int y, int mat[][]){
        int sum=0;
        for(int a=i;a<=x;a++){
            for(int b=j;b<=y;b++){
                sum+=mat[a][b];
            }
        }
        return sum;
    }
}