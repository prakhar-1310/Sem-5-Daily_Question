class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer, HashMap<Integer,Integer>>map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }

        for(int e[] : edges){
            int e1 = e[0];
            int e2 = e[1];
            int cost = e[2];
            map.get(e1).put(e2,Math.min(cost,map.get(e1).getOrDefault(e2,Integer.MAX_VALUE)));
            map.get(e2).put(e1,Math.min(cost,map.get(e2).getOrDefault(e1,Integer.MAX_VALUE)));
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(0,0));
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(dist[rm.vtx]<rm.cost) continue;
            if(rm.cost>=disappear[rm.vtx]){
                continue;  
            }

            for(int ngbr : map.get(rm.vtx).keySet()){
                int newCost = rm.cost+map.get(rm.vtx).get(ngbr);
                if(dist[ngbr]>newCost && newCost<disappear[ngbr]){
                    dist[ngbr] = newCost;
                    pq.add(new Pair(ngbr, rm.cost+map.get(rm.vtx).get(ngbr)));
                }
            }
        }

        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
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