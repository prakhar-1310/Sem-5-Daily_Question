class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        HashSet<Integer>ver = new HashSet<>();
        for(int i[] : edges){
            ver.add(i[0]);
            ver.add(i[1]);
        }

        for(int i : ver){
            map.put(i, new ArrayList<>());
        }

        for(int i[] : edges){
            int e1 = i[0];
            int e2 = i[1];
            map.get(e1).add(e2);
            map.get(e2).add(e1);
        }

        for(int i : map.keySet()){
            if(map.get(i).size()==map.size()-1){
                return i;
            }
        }

        return -1;
    }
}