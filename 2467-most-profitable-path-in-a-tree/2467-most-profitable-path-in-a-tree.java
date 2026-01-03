class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        // 1. Build UNDIRECTED graph
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // 2. Bob path to root (0)
        List<Integer> bobPath = new ArrayList<>();
        path(bob, 0, new HashSet<>(), map, bobPath);

        // 3. Bob time array
        int n = amount.length;
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        for (int i = 0; i < bobPath.size(); i++) {
            bobTime[bobPath.get(i)] = i;
        }

        // 4. Alice DFS using stack
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(0, -1, 0, 0)); // node, parent, time, profit

        int ans = Integer.MIN_VALUE;

        while (!st.isEmpty()) {
            Pair rm = st.pop();

            int gain = amount[rm.vtx];

            if (bobTime[rm.vtx] < rm.time) gain = 0;
            else if (bobTime[rm.vtx] == rm.time) gain /= 2;

            int currProfit = rm.profit + gain;

            boolean isLeaf = true;
            for (int ngbr : map.get(rm.vtx)) {
                if (ngbr != rm.parent) {
                    isLeaf = false;
                    st.push(new Pair(ngbr, rm.vtx, rm.time + 1, currProfit));
                }
            }

            if (isLeaf) {
                ans = Math.max(ans, currProfit);
            }
        }

        return ans;
    }

    // ---------- Bob path DFS (UNCHANGED LOGIC) ----------
    public boolean path(int src, int des,
                        HashSet<Integer> visited,
                        HashMap<Integer, List<Integer>> map,
                        List<Integer> list) {

        if (src == des) {
            list.add(src);
            return true;
        }

        visited.add(src);
        list.add(src);

        for (int ngbr : map.get(src)) {
            if (!visited.contains(ngbr)) {
                if (path(ngbr, des, visited, map, list))
                    return true;
            }
        }

        list.remove(list.size() - 1);
        visited.remove(src);
        return false;
    }

    // ---------- Pair ----------
    class Pair {
        int vtx, parent, time, profit;
        Pair(int v, int p, int t, int pr) {
            vtx = v;
            parent = p;
            time = t;
            profit = pr;
        }
    }
}
