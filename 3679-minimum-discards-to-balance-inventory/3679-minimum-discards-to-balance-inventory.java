class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int count=0;
        Deque<int[]>kept = new ArrayDeque<>();
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=1;i<=arrivals.length;i++){
            int curr = arrivals[i-1];
            int left = i-w+1;

            while(!kept.isEmpty() && kept.peekFirst()[0]<left){
                int old = kept.pollFirst()[1];
                map.put(old,map.get(old)-1);
                if(map.get(old)==0){
                    map.remove(old);
                }
            }

            if(map.getOrDefault(curr,0)>=m){
                count++;
            }
            else{
                kept.offerLast(new int[]{i,curr});
                map.put(curr,map.getOrDefault(curr,0)+1);
            }
            
        }
        return count;
    }
}