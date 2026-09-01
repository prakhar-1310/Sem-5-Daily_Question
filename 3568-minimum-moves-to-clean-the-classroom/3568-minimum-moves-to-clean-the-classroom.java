class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();
        int sr=-1;
        int sc=-1;
        int cnt=0;
        int idL[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(classroom[i].charAt(j)=='S'){
                    sr=i;
                    sc=j;
                }
                else if(classroom[i].charAt(j)=='L'){
                    idL[i][j]=cnt++;
                }
            }
        }

        int masks=1<<cnt;
        int fullmask=masks-1;

        int best[][][] = new int[n][m][masks];
        for(int i[][] : best){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
        }

        int dir[][] = {
            {1,0},{0,1},{0,-1},{-1,0}
        };

        Queue<State>q = new LinkedList<>();
        q.add(new State(sr,sc,energy,0,0));

        while(!q.isEmpty()){
            State rm = q.poll();
            int r = rm.r;
            int c = rm.c;
            int en = rm.en;
            int mask = rm.mask;
            int dist = rm.dist;

            if(r<0 || r>=n || c<0 || c>=m)continue;

            if(classroom[r].charAt(c)=='X')continue;

            if(classroom[r].charAt(c)=='R')en=energy;

            if(classroom[r].charAt(c)=='L'){
                mask|=(1<<idL[r][c]);
            }

            if(mask==fullmask){
                return dist;
            }

            if(best[r][c][mask]>=en){
                continue;
            }
            else{
                best[r][c][mask]=en;
            }

            if(en==0)continue;

            for(int i=0;i<4;i++){
                q.add(new State(r+dir[i][0], c+dir[i][1], en-1, mask, dist+1));
            }
            
        }

        return -1;

    }
    class State{
        int r;
        int c;
        int en;
        int mask;
        int dist;

        public State(int r, int c, int en, int mask, int dist){
            this.r=r;
            this.c=c;
            this.en=en;
            this.mask=mask;
            this.dist=dist;
        }
    }
}