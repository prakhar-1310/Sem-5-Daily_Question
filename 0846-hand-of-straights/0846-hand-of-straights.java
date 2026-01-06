class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer>list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i=0;i<hand.length/groupSize;i++){
            int k=0;
            while(k<list.size() && map.get(list.get(k))==0){
                k++;
            }
            if (k == list.size()) return false;
            int start = list.get(k);
            for(int j=0;j<groupSize;j++){
                int next=start+j;
                if(map.getOrDefault(next,0)==0){
                    return false;
                }
                map.put(next,map.get(next)-1);
            }
        }
        return true;
    }
}