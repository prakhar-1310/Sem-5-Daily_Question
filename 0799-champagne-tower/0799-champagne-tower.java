class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double glass[][] = new double[query_row+2][query_row+2];

        glass[0][0]=poured;

        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                if(glass[i][j]>1){
                    double extra = (glass[i][j]-1)/2.0;
                    glass[i+1][j]+=extra;
                    glass[i+1][j+1]+=extra;
                    glass[i][j]=1;
                }
            }
        }

        return glass[query_row][query_glass];
    }
}