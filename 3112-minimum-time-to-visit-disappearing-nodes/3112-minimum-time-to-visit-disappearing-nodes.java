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
            map.get(e1).put(e2,cost);
            map.get(e2).put(e1,cost);
        }

        HashSet<Integer>visited = new HashSet<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(0,0));
        int dist[] = new int[n];
        Arrays.fill(dist,-1);
        dist[0]=0;

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited.contains(rm.vtx)){
                continue;
            }
            visited.add(rm.vtx);
            if(rm.cost>=disappear[rm.vtx]){
                continue;  
            }
            dist[rm.vtx] = rm.cost;

            for(int ngbr : map.get(rm.vtx).keySet()){
                if(!visited.contains(ngbr)){
                    pq.add(new Pair(ngbr, rm.cost+map.get(rm.vtx).get(ngbr)));
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