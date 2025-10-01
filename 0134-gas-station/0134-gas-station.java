class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tot=0;
        for(int i=0;i<gas.length;i++){
            tot+=(gas[i]-cost[i]);
        }

        if(tot<0){ // no solution 
            return -1;
        }

        int idx=0;
        int currFuel=0;
        for(int i=0;i<gas.length;i++){
            currFuel+=(gas[i]-cost[i]);
            if(currFuel<0){
                currFuel=0;
                idx=i+1;
            }
        }

        return idx;
    }
}