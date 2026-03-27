class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        if(k%m==0) return true;

        k=k%m;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i%2==0){
                    if(mat[i][j]!=mat[i][(j-k+m)%m])return false;
                }

                if(i%2!=0){
                    if(mat[i][j]!=mat[i][(j+k+m)%m])return false;
                }
            }
        }

        return true;
    }
}