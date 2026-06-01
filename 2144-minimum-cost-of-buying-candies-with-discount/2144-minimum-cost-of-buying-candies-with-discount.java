class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int tot=0;
        for(int i=cost.length-1;i>=0;i--){
            tot+=cost[i];
            i--;
            if(i>=0){
                tot+=cost[i];
            }
            i--;
        }

        return tot;
    }
}