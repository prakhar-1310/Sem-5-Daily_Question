class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>>map = new HashMap<>();
        
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i[] : times){
            int v1=i[0];
            int v2 = i[1];
            int cost = i[2];
            map.get(v1).put(v2,cost);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(k,0));

        HashSet<Integer>visited = new HashSet<>();

        List<Integer>list = new ArrayList<>();

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited.contains(rm.vtx)){
                continue;
            }

            visited.add(rm.vtx);

            list.add(rm.cost);

            if(!map.containsKey(rm.vtx))continue;
            for(int ngbr : map.get(rm.vtx).keySet()){
                if(!visited.contains(ngbr)){
                    pq.add(new Pair(ngbr, map.get(rm.vtx).get(ngbr)+rm.cost));
                }
            }
        }
        if(list.size()!=n){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        for(int i : list){
            max = Math.max(max,i);
        }
        return max;
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