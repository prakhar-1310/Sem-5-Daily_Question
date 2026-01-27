class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            time++;
            int front = q.poll();

            tickets[front]--;

            if(tickets[front]!=0){
                q.add(front);
            }
            else{
                if(front==k){
                    return time;
                }
            }
        }
        return time;
        
    }
}