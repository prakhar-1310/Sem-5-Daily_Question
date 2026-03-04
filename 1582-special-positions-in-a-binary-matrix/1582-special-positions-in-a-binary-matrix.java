class Solution {
    public int numSpecial(int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    cnt++;
                }
            }
            row[i]=cnt;
        }

        for(int j=0;j<mat[0].length;j++){
            int cnt=0;
            for(int i=0;i<mat.length;i++){
                if(mat[i][j]==1){
                    cnt++;
                }
            }
            col[j]=cnt;
        }
        for(int i : row){
            System.out.print(i+" ");
        }

        for(int i : col){
            System.out.print(i+" ");
        }
        System.out.println();
        int ans=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && row[i]==1 && col[j]==1){
                    ans++;
                }
            }
        }

        return ans;
    }
}