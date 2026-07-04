class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, HashMap<Integer,Integer>>map = new HashMap<>();
        for(int i[] : roads){
            if(!map.containsKey(i[0])){
                map.put(i[0], new HashMap<>());
            }

            map.get(i[0]).put(i[1],i[2]);

            if(!map.containsKey(i[1])){
                map.put(i[1], new HashMap<>());
            }

            map.get(i[1]).put(i[0],i[2]);
        }

        int ans = Integer.MAX_VALUE;

        Queue<Pair>q = new LinkedList<>();

        q.add(new Pair(1,Integer.MAX_VALUE));
        HashSet<Integer>set = new HashSet<>();
        while(!q.isEmpty()){
            Pair rm = q.poll();
            ans = Math.min(ans,rm.c);

            if(set.contains(rm.v)){
                continue;
            }

            set.add(rm.v);

            for(int ngbr : map.get(rm.v).keySet()){
                if(!set.contains(ngbr)){
                    q.add(new Pair(ngbr, Math.min(rm.c, map.get(rm.v).get(ngbr))));
                }
            }
        }


        return ans;
    }

    class Pair{
        int v;
        int c;

        public Pair(int v, int c){
            this.v=v;
            this.c=c;
        }
    }
}