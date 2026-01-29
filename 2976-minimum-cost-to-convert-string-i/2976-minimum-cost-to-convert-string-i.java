class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashMap<Character, HashMap<Character,Integer>>map = new HashMap<>();
        // original, <changed,cost>

        int memo[][] = new int[26][26];
        for(int i[] : memo){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<original.length;i++){
            char v1= original[i];
            char v2= changed[i];
            int c= cost[i];
            if(map.containsKey(v1)){
                map.get(v1).put(v2, Math.min(map.get(v1).getOrDefault(v2,Integer.MAX_VALUE),c));
            }
            else{
                map.put(v1,new HashMap<>());
                map.get(v1).put(v2,c);
            }
        }

        long tot=0;
        for(int i=0;i<source.length();i++){
            char s = source.charAt(i);
            char t = target.charAt(i);
            if(s==t){
                continue;
            }

            if(memo[s-'a'][t-'a']!=-1){
                tot+=memo[s-'a'][t-'a'];
                continue;
            }

            int c = dijkstra(s,t,map);
            if(c==-1){
                return -1;
            }
            else{
                memo[s-'a'][t-'a']=c;
                tot+=c;
            }
        }

        return tot;
    }

    public int dijkstra(char src, char dest, HashMap<Character, HashMap<Character,Integer>>map){
        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });

        HashSet<Character>visited = new HashSet<>();

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited.contains(rm.vtx)){
                continue;
            }
            visited.add(rm.vtx);

            if(rm.vtx==dest){
                return rm.cost;
            }
            if(!map.containsKey(rm.vtx))continue;
            for(char ch : map.get(rm.vtx).keySet()){
                if(!visited.contains(ch)){
                    pq.add(new Pair(ch, rm.cost+map.get(rm.vtx).get(ch)));
                }
            }
        }
        return -1;
    }

    class Pair{
        char vtx;
        int cost;

        public Pair(char vtx, int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}