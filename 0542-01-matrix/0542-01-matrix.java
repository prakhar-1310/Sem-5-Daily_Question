class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dist[][] = new int [mat.length][mat[0].length];
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    pq.add(new Pair(i,j,0));
                    dist[i][j]=0;
                }
                else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int r[] = {0,0,1,-1};
        int c[] = {1,-1,0,0};

        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            
            if(rem.cost>dist[rem.row][rem.col]){
                continue;
            }

            for(int i=0;i<4;i++){
                int newR = rem.row+r[i];
                int newC = rem.col+c[i];

                if(newR>=0 && newR<mat.length && newC>=0 && newC<mat[0].length){
                    if(dist[newR][newC]>rem.cost+1){
                        dist[newR][newC]=rem.cost+1;
                        pq.add(new Pair(newR,newC, rem.cost+1));
                    }
                }
            } 
        }

        return dist;
    }

    class Pair{
        int row;
        int col;
        int cost;
        public Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}