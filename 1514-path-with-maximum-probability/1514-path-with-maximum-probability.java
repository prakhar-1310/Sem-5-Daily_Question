class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer,HashMap<Integer,Double>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            double cost = succProb[i];
            map.get(e1).put(e2,cost);
            map.get(e2).put(e1,cost);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b.prob,a.prob);
        });

        pq.add(new Pair(start_node, 1.0));
        HashSet<Integer>set = new HashSet<>();

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(set.contains(rm.vtx)){
                continue;
            }

            set.add(rm.vtx);

            if(rm.vtx == end_node){
                return rm.prob;
            }

            for(int ngbr : map.get(rm.vtx).keySet()){
                if(!set.contains(ngbr)){
                    pq.add(new Pair(ngbr, rm.prob*map.get(rm.vtx).get(ngbr)));
                }
            }
        }

        return 0;
    }

    class Pair{
        int vtx;
        double prob;
        public Pair(int vtx, double prob){
            this.vtx = vtx;
            this.prob = prob;
        }
    }
}