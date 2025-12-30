class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
        for(int i[] : flights){
            int v1=i[0];
            int v2 = i[1];
            int cost = i[2];
            if(!map.containsKey(v1)){
                map.put(v1,new HashMap<>());
            }
            map.get(v1).put(v2,cost);
        }

        // HashSet<Integer>visited = new HashSet<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(src,0,0));

        int ans = Integer.MAX_VALUE;
        int[] minStop = new int[n];
        Arrays.fill(minStop, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            // if(visited.contains(rm.vtx)){
            //     continue;
            // }
            // visited.add(rm.vtx);
            if(rm.stop>k+1){
                continue;
            }

            if(rm.stop > minStop[rm.vtx]) continue;
            minStop[rm.vtx] = rm.stop;

            if(rm.vtx == dst && k+1>=rm.stop){
                ans = Math.min(ans,rm.cost);
            }
            if (!map.containsKey(rm.vtx)) continue;
            for(int ngbr : map.get(rm.vtx).keySet()){
                // if(!visited.contains(ngbr)){
                    pq.add(new Pair(ngbr, rm.cost+map.get(rm.vtx).get(ngbr),rm.stop+1));
                // }
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;


    }

    class Pair{
        int vtx;
        int cost;
        int stop;

        public Pair(int vtx, int cost, int stop){
            this.vtx = vtx;
            this.cost = cost;
            this.stop = stop;
        }
    }
}