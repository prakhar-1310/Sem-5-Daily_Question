class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // memo[i] will contain the number of trips to go to port i
        int[] memo=new int[boxes.length];
        int weight=0, left=0, right=0, lastDiffCity=-1, trips=0;
        while(right<boxes.length) {
            weight+=boxes[right][1];
            // description contstraints
            while(weight>maxWeight||right-left+1>maxBoxes||
                // if two ports have the same cost to start, be greedy and
                // choose the rightmost
                (left>0&&left<right&&memo[left]==memo[left-1])) { 
                // if the city removed had a trip to the next city we must
                // remove that trip. That trip is zero if its the same port
                if(boxes[left][0]!=boxes[left+1][0]) trips--;
                // remove the weight of the removed box
                weight-=boxes[left++][1];
            }
            // lets mark the last diff city we had. If it was not the last one
            // it means we have boxes in the same port
            if((right==0||boxes[right-1][0]!=boxes[right][0]))
                trips++;
            // Trips contains the trip from storage to start port, so we
            // only need to add one being the trip from the last post to
            // storage. If the start node is left the number of trips are
            // trips to left-1 + trip to storage + trip from storage to left
            // + left to right
            memo[right++]=left==0?trips:memo[left-1]+1+trips;
        }
        // +1 for trip to storage
        return memo[memo.length-1]+1;
    }
}