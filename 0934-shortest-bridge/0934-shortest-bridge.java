class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<int[]>list1=new ArrayList<>();
        List<int[]>list2 = new ArrayList<>();
        int island=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(island==1){
                        helper(grid, list1, i, j);
                    }
                    else{
                        helper(grid, list2, i, j);
                    }
                    island++;
                }
            }
        }

        int dist=Integer.MAX_VALUE;
        for(int i[] : list1){
            for(int j[] : list2){
                int temp = Math.abs(i[0]-j[0]) + Math.abs(i[1]-j[1]);
                dist=Math.min(dist, temp);
            }
        }

        return dist-1;
    }

    public void helper(int grid[][], List<int[]>list, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return;
        }

        list.add(new int[]{i,j});
        grid[i][j]=0;

        // left
        helper(grid, list, i, j-1);

        // right
        helper(grid, list, i, j+1);

        // up
        helper(grid, list, i-1, j);

        // down
        helper(grid, list, i+1, j);
    }
}