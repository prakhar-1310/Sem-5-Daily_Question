class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<num;i++){
            if(sum<9){
                sb.append(sum);
                sum=0;
            }
            else{
                sb.append(9);
                sum-=9;
            }
        }

        return sum==0 ? sb.toString() : "";
    }
}