class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        int max = x;
        for(int i : forbidden){
            set.add(i);
            max = Math.max(max,i);
        }

        int ub = max+a+b; // upperBound

        boolean[][] visited = new boolean[ub + 1][2];
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Pair rm = q.poll();
            
            if(rm.vtx==x){
                return rm.cost;
            }

            // add ngbr

            if(rm.lastMove==0  && rm.vtx-b>=0 && !set.contains(rm.vtx-b) && !visited[rm.vtx-b][1]){
                q.add(new Pair(rm.vtx-b, rm.cost+1,1));
                visited[rm.vtx-b][1]=true;
            }

            if(!set.contains(rm.vtx+a)&& rm.vtx+a<=ub &&!visited[rm.vtx+a][0]){
                q.add(new Pair(rm.vtx+a, rm.cost+1,0));
                visited[rm.vtx+a][0]=true;
            }
        }

        return -1;
    }

    class Pair{
        int vtx;
        int cost;
        int lastMove=0; // 0 mean lastMove forward; 1 means last move backward
        public Pair(int vtx, int cost, int lastMove){
            this.vtx = vtx;
            this.cost = cost;
            this.lastMove = lastMove;
        }
    }
}