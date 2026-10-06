class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            return aliceValues[b]+bobValues[b]-aliceValues[a]-bobValues[a];
        });

        int n = aliceValues.length;
        for(int i=0;i<n;i++){
            pq.add(i);
        }


        int alice=0;
        int bob=0;
        
        for(int i=0;i<n;i++){
            if(i%2==0){ // alice turn
                int idx = pq.poll();
                alice+=aliceValues[idx];
            }
            else{ // bob turn
                int idx = pq.poll();
                bob+=bobValues[idx];
            }
        }

        if(bob>alice){
            return -1;
        }
        else if(bob<alice){
            return 1;
        }
        return 0;
    }
}