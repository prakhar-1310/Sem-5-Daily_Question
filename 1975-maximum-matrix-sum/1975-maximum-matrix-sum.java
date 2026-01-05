class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count=0;
        int min = Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int num = Math.abs(matrix[i][j]);
                sum = sum + num;
                min = Math.min(min,num);
                if(matrix[i][j]<0){
                    count++;
                }
            }
        }

        if(count%2==0){
            return sum;
        }
        return sum-2*min;

    }
}