class Solution {
    static final int MOD = 1_000_000_007;
    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }

        for(int i[] : edges){
            int v1 = i[0];
            int v2 = i[1];
            int cost = i[2];
            map.get(v1).put(v2,cost);
            map.get(v2).put(v1,cost);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(n, 0));
        dist[n] = 0;

        while (!pq.isEmpty()) {
            Pair rm = pq.poll();

            if (rm.cost > dist[rm.vtx]) continue;

            for (int ngbr : map.get(rm.vtx).keySet()) {
                int wt = map.get(rm.vtx).get(ngbr);
                if (dist[ngbr] > rm.cost + wt) {
                    dist[ngbr] = rm.cost + wt;
                    pq.add(new Pair(ngbr, dist[ngbr]));
                }
            }
        }

        Integer[] dp = new Integer[n + 1];
        return dfs(1, n, map, dist, dp);

    }

    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.cost = cost;
            this.vtx = vtx;
        }
    }

    private int dfs(int src, int n,
                    HashMap<Integer, HashMap<Integer, Integer>> graph,
                    int[] dist, Integer[] dp) {

        if (src == n) return 1;
        if (dp[src] != null) return dp[src];

        long ways = 0;

        for (int ngbr : graph.get(src).keySet()) {
            if (dist[src] > dist[ngbr]) {
                ways = (ways + dfs(ngbr, n, graph, dist, dp)) % MOD;
            }
        }

        dp[src] = (int) ways;
        return dp[src];
    }
}