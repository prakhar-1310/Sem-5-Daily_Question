class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int e[] : edges){
            int e1 = e[0];
            int e2 = e[1];

            map.get(e1).add(e2);
            map.get(e2).add(e1);
        }

        PriorityQueue<Pair>q = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });

        q.add(new Pair(1,0));
        int dist[][] = new int[n+1][2];
        for(int i[]:dist){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dist[1][0]=0;

        while(!q.isEmpty()){
            Pair rm = q.poll();
            
            int departTime = rm.cost;
            if((departTime/change)%2==1){ // means red
                departTime = (departTime/change + 1)*change;
            } 

            for(int ngbr : map.get(rm.vtx)){
                int newTime = departTime + time;
                
                if(dist[ngbr][0]>newTime){
                    dist[ngbr][1]=dist[ngbr][0];
                    dist[ngbr][0]=newTime;
                    q.add(new Pair(ngbr, newTime));
                }
                else if(dist[ngbr][1]>newTime && dist[ngbr][0]<newTime){
                    dist[ngbr][1]=newTime;
                    q.add(new Pair(ngbr, newTime));
                }
            
            }
        }

        return dist[n][1];
    }

    class Pair{
        int vtx;
        int cost;

        public Pair(int vtx, int cost){
            this.cost=cost;
            this.vtx = vtx;
        }
    }
}