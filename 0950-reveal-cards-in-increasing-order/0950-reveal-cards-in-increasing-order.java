class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int ans[] = new int[deck.length];

        int j=0;

        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }
        
        for(int i : deck){
            ans[q.poll()]=i;

            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }

        return ans;
    }
}