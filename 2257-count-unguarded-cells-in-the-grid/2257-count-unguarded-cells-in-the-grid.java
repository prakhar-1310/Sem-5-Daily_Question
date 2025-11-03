class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 3 means guard
        // 2 means wall
        // 0 means not guarded

        int mat[][] = new int [m][n];

        for(int arr[] : guards){
            int i = arr[0];
            int j = arr[1];
            mat[i][j]=3;
        }

        for(int arr[] : walls){
            mat[arr[0]][arr[1]]=2;
        }

        for(int arr[] : guards){
            helper(arr[0], arr[1], "up", mat);
            helper(arr[0], arr[1], "down", mat);
            helper(arr[0], arr[1], "left", mat);
            helper(arr[0], arr[1], "right", mat);
        }

        

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void helper(int i, int j, String dir, int mat[][]){
        if(i<0|| i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]==2){
            return;
        }
        mat[i][j]=1;// mark cell guarded
        if(dir.equals("up")){
            helper(i-1,j,dir,mat);
        }
        else if(dir.equals("down")){
            helper(i+1,j,dir,mat);
        }
        else if(dir.equals("left")){
            helper(i,j-1,dir,mat);
        }
        else if(dir.equals("right")){
            helper(i,j+1,dir,mat);
        }
    }
}