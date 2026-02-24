class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }

        for(int i[] : prerequisites){
            int v1 = i[0];
            int v2 = i[1];
            map.get(v1).add(v2);
        }
        List<Boolean>list = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            list.add(helper(map, queries[i][0], queries[i][1]));
        }
        
        return list;
    }

    public boolean helper(HashMap<Integer,List<Integer>>map, int src, int desti){
        Queue<Integer>q = new LinkedList<>();
        q.add(src);
        HashSet<Integer>set = new HashSet<>();
        while(!q.isEmpty()){
            int rm = q.poll();

            if(set.contains(rm))continue;

            set.add(rm);

            if(rm==desti){
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