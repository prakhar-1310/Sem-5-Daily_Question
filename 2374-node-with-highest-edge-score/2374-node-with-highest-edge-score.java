class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i =0;i<edges.length;i++){
            int v1 = i;
            int v2 = edges[i];
            if(!map.containsKey(v2)){
                map.put(v2, new ArrayList<>());
            }
            map.get(v2).add(v1);
        }

        long max=Integer.MIN_VALUE;
        int node =0;
        for(int i : map.keySet()){
            long sum=0;
            for(int j : map.get(i)){
                sum+=j;
            }
            if(sum>max){
                max = sum;
                node = i;
            }
            else if(sum==max && node>i){
                node=i;
            }
        }

        return node;
    }
}