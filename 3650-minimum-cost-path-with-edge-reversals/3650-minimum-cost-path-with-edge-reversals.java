class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2 * w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            if(dis[node] < d){
                continue;
            }
            for(int[] nbr : adj.get(node)){
                int nn = nbr[0];
                int wt = nbr[1];
                if(d + wt < dis[nn]){
                    dis[nn] = d + wt;
                    pq.add(new int[]{nn, dis[nn]});
                }
            }
        }
        return dis[n - 1] == Integer.MAX_VALUE ? -1 : dis[n - 1]; 
    }
}