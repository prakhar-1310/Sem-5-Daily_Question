class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer>q = new LinkedList<>();

        List<List<Integer>>rev = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            rev.add(new ArrayList<>());
        }
        // outdeg
        int out[] = new int [graph.length];
        for(int i=0;i<graph.length;i++){
            out[i]+=graph[i].length;
            for(int v : graph[i]){
                rev.get(v).add(i);
            }
        }

        for(int i=0;i<graph.length;i++){
            if(out[i]==0){
                q.add(i);
            }
        }

        List<Integer>list = new ArrayList<>();

        while(!q.isEmpty()){
            int r = q.poll();

            list.add(r);

            for(int i : rev.get(r)){
                out[i]--;
                if(out[i]==0){
                    q.add(i);
                }
            }
        }

        Collections.sort(list);

        return list;
    }
}