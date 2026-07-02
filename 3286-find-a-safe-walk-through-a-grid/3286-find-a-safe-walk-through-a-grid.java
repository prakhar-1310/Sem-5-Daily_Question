class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dis = new int[n][m];
        for(int[] i : dis)
        Arrays.fill(i, Integer.MIN_VALUE);
        dis[0][0] = health - grid.get(0).get(0);
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, dis[0][0]});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            if(dis[x][y] > d) continue;
            for(int[] di : dir){
                int newx = di[0] + x;
                int newy = di[1] + y;
                if(newx >= 0 && newx < n && newy < m && newy >= 0){
                    int wt = grid.get(newx).get(newy);
                    if(d - wt > dis[newx][newy]){
                        dis[newx][newy] = d - wt;
                        pq.add(new int[]{newx, newy, d - wt});
                    }
                }
            }
        }
        return dis[n - 1][m - 1] > 0;
    }
}