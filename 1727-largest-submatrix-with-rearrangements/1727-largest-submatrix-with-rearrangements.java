class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int tot=0;
        int hei[] = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hei[j]=0;
                }
                else {
                    hei[j]+=1;
                }
            }

            Arrays.sort(hei);
            for(int k=0;k<hei.length;k++){
                int width = hei.length-k;
                tot = Math.max(tot, width*hei[k]);
            }
        }
        return tot;
    }
}