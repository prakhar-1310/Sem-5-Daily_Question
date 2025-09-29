class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minr=0;
        int maxr=matrix.length-1;
        int minc=0;
        int maxc=matrix[0].length-1;
        int tot=matrix.length*matrix[0].length;
        int c=0;

        List<Integer>list = new ArrayList<>();
        while(c<tot){
            for(int i=minc;i<=maxc && c<tot;i++){
                list.add(matrix[minr][i]);
                c++;
            }
            minr++;

            for(int i=minr;i<=maxr && c<tot;i++){
                list.add(matrix[i][maxc]);
                c++;
            }
            maxc--;

            for(int i=maxc;i>=minc && c<tot;i--){
                list.add(matrix[maxr][i]);
                c++;
            }
            maxr--;

            for(int i=maxr;i>=minr && c<tot;i--){
                list.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }

        return list;
    }
}