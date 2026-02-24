class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int v1 = i;
            int v2 = edges[i];
            if(!map.containsKey(v1)){
                map.put(v1,new ArrayList<>());
            }
            map.get(v1).add(v2);
        }

        long in[] = new long[edges.length];

        for(int v : map.keySet()){
            for(int i : map.get(v)){
                in[i]+=v;
            }
        }
        long max=0;
        int node=0;
        for(int i=0;i<in.length;i++){
            if(max<in[i]){
                max=in[i];
                node=i;
            }
        }

        return node;
    }
}