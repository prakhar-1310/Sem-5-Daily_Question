class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }

        for(int e[] : edges){
            int v1 = e[0];
            int v2 = e[1];
            int c = e[2];
            map.get(v1).put(v2, Math.min(c, map.get(v1).getOrDefault(v2,Integer.MAX_VALUE)));
            map.get(v2).put(v1, Math.min(c, map.get(v2).getOrDefault(v1,Integer.MAX_VALUE)));
        }

        int dist[] = new int[n];
        Arrays.fill(dist,-1);
        dist[0]=0;

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        
        pq.add(new Pair(0,0));
        HashSet<Integer>set = new HashSet<>();

        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            if(set.contains(rm.vtx))continue;
            set.add(rm.vtx);
            if(rm.cost>=disappear[rm.vtx]){
                continue;
            }
            dist[rm.vtx]=rm.cost;

            for(int ngbr : map.get(rm.vtx).keySet()){
                if(!set.contains(ngbr)){
                    pq.add(new Pair(ngbr, map.get(rm.vtx).get(ngbr)+rm.cost));
                }
            }
        }

        return dist;
    }

    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}