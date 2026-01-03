class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int e[] : edges){
            int e1 = e[0];
            int e2 = e[1];
            map.get(e1).add(e2);
            map.get(e2).add(e1);
        }

        int ans = Integer.MAX_VALUE;

        Queue<Pair>q = new LinkedList<>();
        HashMap<Integer,Integer>visited = new HashMap<>(); // vtx:dist

        for(int i=0;i<n;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new Pair(i,0));

            while(!q.isEmpty()){
                Pair rm = q.poll();
                if(visited.containsKey(rm.vtx)){
                    int c1 = rm.cost;
                    int c2 = visited.get(rm.vtx);
                    ans = Math.min(ans,c1+c2);
                    continue;
                }
                visited.put(rm.vtx,rm.cost);

                for(int ngbr : map.get(rm.vtx)){
                    if(!visited.containsKey(ngbr)){
                        q.add(new Pair(ngbr, rm.cost+1));
                    }
                }
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx,int cost){
            this.vtx = vtx;
            this.cost = cost;
        } 
    }
}