class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,Long>map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int vtx = edges[i];
            long score = i;
            map.put(vtx,map.getOrDefault(vtx,0L)+score);
        }

        int ans=0;
        long max=0;
        for(int i : map.keySet()){
            if(max<map.get(i)){
                max = map.get(i);
                ans = i;
            }
        }

        return ans;
    }
}