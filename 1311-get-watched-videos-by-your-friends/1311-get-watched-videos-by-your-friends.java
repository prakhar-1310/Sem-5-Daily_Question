class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            int e1 = friends[i][0];
            int e2 = friends[i][1];
            map.put(i,new ArrayList<>());
            map.get(i).add(e1);
            map.get(i).add(e2);
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        pq.add(new Pair(id,0));

        List<Integer>list = new ArrayList<>();
        HashSet<Integer>visited = new HashSet<>();

        while(!pq.isEmpty()){
            Pair rm = pq.poll();

            if(visited.contains(rm.vtx)){
                continue;
            }

            visited.add(rm.vtx);

            if(rm.cost==level){
                list.add(rm.vtx);
            }

            for(int ngbr : map.get(rm.vtx)){
                if(!visited.contains(ngbr)){
                    pq.add(new Pair(ngbr, rm.cost+1));
                }
            }
        }

        HashMap<String,Integer>freq = new HashMap<>();
        for(int vtx : list){
            for(String ch : watchedVideos.get(vtx)){
                freq.put(ch , freq.getOrDefault(ch,0)+1);
            }
        }

        List<String> ans = new ArrayList<>(freq.keySet());
        Collections.sort(ans,(a,b)->{
            if(freq.get(a)==freq.get(b)){
                return a.compareTo(b);
            }
            return freq.get(a)-freq.get(b);
        });

        return ans;
    }

    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
}