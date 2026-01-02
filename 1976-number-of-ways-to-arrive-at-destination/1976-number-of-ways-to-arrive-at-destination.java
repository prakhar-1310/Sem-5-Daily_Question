class Solution {
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer,HashMap<Integer,Long>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        int mod = 1000000007;

        for(int i[] : roads){
            int v1 = i[0];
            int v2 = i[1];
            long cost = i[2];

            map.get(v1).put(v2,cost);
            map.get(v2).put(v1,cost);
        }
        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->{
            return Long.compare(a.cost,b.cost);
        });
        pq.add(new Pair(0,0));

        long dist[] = new long [n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0L;

        long ways[] = new long[n];
        ways[0]=1L;

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(dist[rm.vtx]<rm.cost){
                continue;
            }

            for(int ngbr : map.get(rm.vtx).keySet()){
                long newCost = map.get(rm.vtx).get(ngbr)+rm.cost;
                if(dist[ngbr]>newCost){
                    dist[ngbr]=newCost;
                    ways[ngbr] = ways[rm.vtx];
                    pq.add(new Pair(ngbr,newCost));
                }
                else if(dist[ngbr]==newCost){
                    ways[ngbr] = (ways[ngbr]+ways[rm.vtx])%mod;
                }
            }
        }

        return (int)ways[n-1];
    }

    class Pair{
        int vtx;
        long cost;
        public Pair(int vtx,long cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}