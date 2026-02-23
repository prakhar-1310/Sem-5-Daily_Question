class Solution {
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer,HashMap<Integer,Long>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int e[] : roads){
            int v1 = e[0];
            int v2 = e[1];
            long c = e[2];

            map.get(v1).put(v2,c);
            map.get(v2).put(v1,c);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Long.compare(a.cost,b.cost);
        });
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        long ways[] = new long[n];
        ways[0]=1;

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(dist[rm.vtx]<rm.cost){
                continue;
            }

            for(int ngbr : map.get(rm.vtx).keySet()){
                if(dist[ngbr]>rm.cost+map.get(rm.vtx).get(ngbr)){
                    dist[ngbr]=rm.cost+map.get(rm.vtx).get(ngbr);
                    ways[ngbr] = ways[rm.vtx];
                    pq.add(new Pair(ngbr, dist[ngbr]));
                }
                else if(dist[ngbr]==rm.cost+map.get(rm.vtx).get(ngbr)){
                    ways[ngbr]=(ways[ngbr]+ways[rm.vtx])%1000_000_007;
                }
            }
        }

        return (int)ways[n-1];
    }

    class Pair{
        long cost;
        int vtx;
        public Pair(int vtx, long cost){
            this.cost = cost;
            this.vtx = vtx;
        }
    }
}