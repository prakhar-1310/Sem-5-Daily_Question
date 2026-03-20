class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n-k+1][m-k+1];

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                List<Integer>list = new ArrayList<>();

                for(int h=i;h<i+k;h++){
                    for(int v=j;v<j+k;v++){
                        list.add(grid[h][v]);
                    }
                }

                Collections.sort(list);

                int min=Integer.MAX_VALUE;
                for(int v=1;v<list.size();v++){
                    if(list.get(v)!=list.get(v-1)){
                        min = Math.min(list.get(v)-list.get(v-1),min);
                    }
                }
                ans[i][j] = min==Integer.MAX_VALUE ? 0 :min;
            }
        }

        return ans;
    }
}