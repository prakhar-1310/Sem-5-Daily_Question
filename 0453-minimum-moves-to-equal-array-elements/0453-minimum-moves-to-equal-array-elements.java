class Solution {
    public int minMoves(int[] nums) {
       // Incrementing n−1 elements is equivalent to decreasing 1 element by 1 in reverse (because all others go up by 1).
       int min= Integer.MAX_VALUE;
       for (int i : nums){
        min = Math.min(i,min);
       }
       int opr=0;
       for (int i : nums){
        opr += Math.abs(min-i);
       }
       return opr;
    }
}