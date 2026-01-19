class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefixSumGrid = new int[rows+1][cols+1];
        for(int i= 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //sum of all elements in the 2D matrix from (0,0) to (i,j)
                prefixSumGrid[i+1][j+1] = mat[i][j] 
                                        + prefixSumGrid[i][j+1] //top
                                        + prefixSumGrid[i+1][j] //left
                                        - prefixSumGrid[i][j]; // remove diagonal
            }
        }

        int maxK = 0;
        int k = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //check if from current position a square matrix of 'k' rows and 'k' cols is possible or not
                while(true){
                    k = maxK + 1; // if already found a maximum, no need to start from 1
                    if(i+k <= rows && j+k <= cols){
                        //check the threshold and sum possibility
                        //the bottom right coordinate
                        int sum = prefixSumGrid[i+k][j+k]
                                - prefixSumGrid[i][j+k]
                                - prefixSumGrid[i+k][j]
                                + prefixSumGrid[i][j];
                        if(sum <= threshold){
                            maxK = k;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return maxK;
        
    }
}