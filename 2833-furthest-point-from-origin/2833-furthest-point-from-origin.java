class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        for (int i=0;i<moves.length();i++){
            if (moves.charAt(i)=='L'){
                left++;
            }
            else if (moves.charAt(i)=='R'){
                right++;
            }
        }

        int dash= moves.length()-left-right;

        if (left>right){
            return Math.abs(left+dash-right);
        }
        return Math.abs(right+dash-left);
    }
}