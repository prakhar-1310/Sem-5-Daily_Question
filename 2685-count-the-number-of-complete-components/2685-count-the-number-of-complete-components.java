class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i[] : edges){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }

        int cnt=0;
        Queue<Integer>q = new LinkedList<>();
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                continue;
            }

            q.add(i);
            List<Integer>ll = new ArrayList<>();
            while(!q.isEmpty()){
                int r = q.poll();
                if(set.contains(r))continue;
                ll.add(r);
                set.add(r);
                for(int ngbr : map.get(r)){
                    if(!set.contains(ngbr)){
                        q.add(ngbr);
                    }
                }
            }


            int flag=0;
            for(int vtx : ll){
                if(map.get(vtx).size()!=ll.size()-1){
                    flag=1;
                    break;
                }
            }

            if(flag==0){
                cnt++;
            }

        }

        return cnt;
    }
}