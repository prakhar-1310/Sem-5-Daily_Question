class Solution {
    public int minBishopMoves(int[] s, int[] t) {
        if((s[0]+s[1])%2!=(t[0]+t[1])%2)return -1;

        int dir[][] = {
            {1,1},{1,-1},{-1,+1},{-1,-1}
        };

        for(int i=0;i<4;i++){
            int x=s[0];
            int y=s[1];

            while(x<9 && x>0 && y<9 && y>0){
                if(x==t[0] && y==t[1]){
                    return 1;
                }

                x+=dir[i][0];
                y+=dir[i][1];
            }
        }

        return 2;
    }

    
}