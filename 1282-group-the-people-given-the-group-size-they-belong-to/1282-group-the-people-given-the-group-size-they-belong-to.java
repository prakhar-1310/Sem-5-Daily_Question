class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //Arrays.sort(groupSizes);
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        List<List<Integer>>list = new ArrayList<>();
        int id=0;
        for(int i : groupSizes){
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
            map.get(i).add(id++);
            if(i==map.get(i).size()){
                list.add(map.get(i));
                map.remove(i);
            }
        }

        return list;


        
    }
}