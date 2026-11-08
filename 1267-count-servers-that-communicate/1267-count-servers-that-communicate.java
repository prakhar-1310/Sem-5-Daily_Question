class Solution {
    public int countServers(int[][] grid) {
        // int ans=0;
        // for (int i=0;i<grid.length;i++){
        //     for (int j=0;j<grid[0].length;j++){
        //         int c=0;
        //         int count=0;
        //         if (grid[i][j]==1){
        //             for (int k =0;k<grid.length;k++){
        //                 if (grid[k][j]==1){
        //                     c++;
        //                 }
        //             }
        //             if(c>=2){
        //                 count=1;
        //             }
        //             c=0;
        //             for (int k = 0;k<grid[0].length;k++){
        //                 if (grid[i][k]==1){
        //                     c++;
        //                 }
        //             }
        //             if(c>=2){
        //             count=1;
        //             }
        //         }
        //         ans+=count;
        //     }
        // }
        // return ans;



        // method=2

        int row[] = new int [grid.length];
        int col[] = new int [grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1 && (row[i]>1 || col[j]>1)){
                    ans++;
                }
            }
        }
        return ans;

    }
}