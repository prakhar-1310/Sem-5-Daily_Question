import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        if (edges.length == 0) return -1;

        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int mxEdge = Integer.MIN_VALUE;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            mxEdge = Math.max(mxEdge, w);
        }

        // Topological sort using DFS
        boolean[] vis = new boolean[n];
        List<Integer> topo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i, vis, adj, topo);
        }
        Collections.reverse(topo);

        // Check function
        final List<Integer> topoOrder = topo;
        final List<List<int[]>> graph = adj;
        java.util.function.IntPredicate check = (mid) -> {
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            for (int u : topoOrder) {
                if (dist[u] == Long.MAX_VALUE) continue;
                for (int[] edge : graph.get(u)) {
                    int v = edge[0], w = edge[1];
                    if (w < mid || !online[v]) continue;
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }
            }
            return dist[n - 1] <= k;
        };

        // Binary search
        if (!check.test(0)) return -1;
        int low = 0, high = mxEdge, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check.test(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private void dfs(int u, boolean[] vis, List<List<int[]>> adj, List<Integer> topo) {
        vis[u] = true;
        for (int[] e : adj.get(u)) {
            if (!vis[e[0]]) dfs(e[0], vis, adj, topo);
        }
        topo.add(u);
    }
}