class Solution {
    public boolean isPerfectSquare(int num) {
        int low =1;
        int high = (num+1)/2;
        if (num==1){
            return true;
        }
        while(low<=high){
            int mid =low+(high-low)/2;
            long sq = (long)mid*(long)mid;
            if (sq==num ){
                return true;
            }else if (sq>num){
                high=mid-1;
            }else if(sq<num){
                low=mid+1;
            }
        }
        return false;
    }
}