class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Character>pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char i : map.keySet()){
            pq.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char i = pq.poll();
            for(int j =0 ;j<map.get(i);j++){
                sb.append(i);
            }
            
        }
        return sb.toString();
    }
}