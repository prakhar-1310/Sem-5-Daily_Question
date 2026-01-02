class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.effort - b.effort;
        });
        int dist[][] = new int [heights.length][heights[0].length];
        for(int i[] : dist){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));

        int r[] = {0,0,1,-1};
        int c[] = {1,-1,0,0};

        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            if(rm.effort>dist[rm.row][rm.col]){
                continue;
            }
            
            for(int i=0;i<4;i++){
                int newR = rm.row+r[i];
                int newC = rm.col+c[i];

                if(newR>=0 && newR<heights.length && newC>=0 && newC<heights[0].length){
                    int newEffort = Math.max(rm.effort, Math.abs(heights[rm.row][rm.col]-heights[newR][newC]));
                    if(dist[newR][newC]>newEffort){
                        dist[newR][newC]=newEffort;
                        pq.add(new Pair(newR,newC,newEffort));
                    }
                }
            }
        }

        return dist[heights.length-1][heights[0].length-1];

    }

    class Pair{
        int row;
        int col;
        int effort;
        public Pair(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
}