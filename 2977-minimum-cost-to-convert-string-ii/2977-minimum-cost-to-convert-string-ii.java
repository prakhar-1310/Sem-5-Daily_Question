class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        HashMap<String, HashMap<String, Integer>>map = new HashMap<>();
        for(int i=0;i<original.length;i++){
            String v1 = original[i];
            String v2 = changed[i];
            int c = cost[i];

            if(map.containsKey(v1)){
                map.get(v1).put(v2, Math.min(map.get(v1).getOrDefault(v2,Integer.MAX_VALUE),c));
            }
            else{
                map.put(v1, new HashMap<>());
                map.get(v1).put(v2,c);
            }
        }

        long dp[] = new long[target.length()+1];
        Arrays.fill(dp,-1);

        HashMap<String, HashMap<String, Long>> memo = new HashMap<>();// for dijkstra

        long res = solve(0,dp,map, source, target,memo);

        return res>=Integer.MAX_VALUE?-1:res;
    }

    public long solve(int idx, long dp[], HashMap<String,HashMap<String,Integer>>map,String src, String dest,HashMap<String, HashMap<String, Long>> memo){
        if(idx>=src.length()){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }
        long ans = Integer.MAX_VALUE;
        if(src.charAt(idx)==dest.charAt(idx)){
            ans = solve(idx+1,dp,map,src,dest,memo);
        }

        for(String ori : map.keySet()){
            int len = ori.length();
            if(idx+len>src.length())continue;
            String str = src.substring(idx,idx+len);

            if(!str.equals(ori))continue;

            String str2 = dest.substring(idx,idx+len);
            long cost=0;
            if (memo.containsKey(str) && memo.get(str).containsKey(str2)) {
                cost= memo.get(str).get(str2);
            }
            else{
                cost = dijkstra(str,str2,map);
                memo.put(str,new HashMap<>());
                memo.get(str).put(str2,cost);
            }

            if(cost!=Integer.MAX_VALUE){
                long next = solve(idx+len,dp,map,src,dest,memo);

                if(next!=Integer.MAX_VALUE){
                    ans = Math.min(ans,next+cost);
                }
            }
        }

        return dp[idx]=ans;
    }

    public long dijkstra(String src, String dest, HashMap<String, HashMap<String,Integer>>map){
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });

        pq.add(new Pair(src,0));

        HashSet<String>visited = new HashSet<>();

        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            if(visited.contains(rm.vtx)){
                continue;
            }

            visited.add(rm.vtx);

            if(rm.vtx.equals(dest)){
                return rm.cost;
            }

            if(!map.containsKey(rm.vtx))continue;

            for(String ngbr : map.get(rm.vtx).keySet()){
                if(!visited.contains(ngbr)){
                    pq.add(new Pair(ngbr, map.get(rm.vtx).get(ngbr)+rm.cost));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    class Pair{
        String vtx;
        int cost;

        public Pair(String vtx, int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}