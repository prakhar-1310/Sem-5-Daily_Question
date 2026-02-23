class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int e[] : edges){
            int v1 = e[0];
            int v2 = e[1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        Queue<Integer>q = new LinkedList<>();
        q.add(source);
        HashSet<Integer>set = new HashSet<>();
        while(!q.isEmpty()){
            int rm = q.poll();

            if(set.contains(rm)){
                continue;
            }

            set.add(rm);

            if(rm==destination){
                return true;
            }

            for(int ngbr : map.get(rm)){
                if(!set.contains(ngbr)){
                    q.add(ngbr);
                }
            }
        }
        return false;
    }
}