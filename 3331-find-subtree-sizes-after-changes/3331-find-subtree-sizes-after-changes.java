class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=1;i<parent.length;i++){
            int par = parent[i];
        
            map.get(par).add(i);
        }

        int lastSeen[] = new int[26];
        Arrays.fill(lastSeen, -1);

        int finalSize[] = new int[parent.length];
        Arrays.fill(finalSize, 1);

        helper(lastSeen, finalSize, map, parent, s, 0);

        return finalSize;
    }

    public void helper(int lastSeen[], int finalSize[], HashMap<Integer, List<Integer>>map,
    int parent[], String s, int node){

        int nearestAnc = lastSeen[s.charAt(node)-'a'];

        lastSeen[s.charAt(node)-'a'] = node;

        for(int child : map.get(node)){
            helper(lastSeen, finalSize, map, parent, s, child);
        }

        lastSeen[s.charAt(node)-'a'] = nearestAnc;

        if(nearestAnc==-1){
            if(parent[node]!=-1){
                finalSize[parent[node]]+=finalSize[node];
            }
            
        }
        else{
            finalSize[nearestAnc]+=finalSize[node];
        }
    }
}