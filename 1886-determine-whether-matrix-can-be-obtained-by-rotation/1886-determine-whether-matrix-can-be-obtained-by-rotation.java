class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            int rot[][] = rotate(mat);
            if(equals(rot,target))return true;
            mat=rot;
        }
        return false;
    }

    public boolean equals(int arr1[][], int arr2[][]){
        int n = arr1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr1[i][j]!=arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int mat[][]){
        int n = mat.length;
        int rot[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rot[i][j]=mat[Math.abs(j-n+1)][i];
            }
        }
        return rot;
    }
}