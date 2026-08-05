class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i[] : invocations){
            if(!map.containsKey(i[0])){
                map.put(i[0], new ArrayList<>());
            }
            map.get(i[0]).add(i[1]);
        }
        HashSet<Integer>bug=new HashSet<>();

        Queue<Integer>q = new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int rem = q.poll();

            if(bug.contains(rem))continue;

            bug.add(rem);

            if(!map.containsKey(rem))continue;

            for(int ngbr : map.get(rem)){
                if(!bug.contains(ngbr)){
                    q.add(ngbr);
                }
            }
        }

        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        System.out.println(bug);
        for(int i=0;i<n;i++){
            if(!bug.contains(i) && map.containsKey(i)){
                for(int ngbr : map.get(i)){
                    if(bug.contains(ngbr)){
                        return list;
                    }
                }
            }
        }

        list=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!bug.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}