class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int max=0;
        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            int hypoSq =l*l + b*b;
            if(hypoSq>max){
                max = hypoSq;
                ans = l*b;
            }
        }
        return ans;
    }
}