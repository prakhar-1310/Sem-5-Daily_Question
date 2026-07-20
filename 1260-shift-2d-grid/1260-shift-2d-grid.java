class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>>ll = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        if(k==0){
            for(int i=0;i<n;i++){
                List<Integer>list = new ArrayList<>();
                for(int j=0;j<m;j++){
                    list.add(grid[i][j]);
                }
                ll.add(list);
            }

            return ll;
        }
    
        for(int h=0;h<k;h++){
            ll = new ArrayList<>();
            for(int i=0; i<n; i++){
                List<Integer>list = new ArrayList<>();
                list.add(grid[(n-1+i)%n][m-1]);
                for(int j=0;j<m-1;j++){
                    list.add(grid[i][j]);
                }
                ll.add(list);
            }


            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j]=ll.get(i).get(j);
                }
            }

        }

        return ll;
    }
}