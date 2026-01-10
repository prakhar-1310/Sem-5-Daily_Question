class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer>map = new HashMap<>();// rain[i], idx
        TreeSet<Integer>set = new TreeSet<>();// index of dry day
        int ans[] = new int[rains.length];
        Arrays.fill(ans,1);
        for(int i =0;i<rains.length;i++){
            if(rains[i]==0){
                set.add(i);
            }
            else{
                ans[i]=-1;
                if(map.containsKey(rains[i])){
                    Integer idx = set.higher(map.get(rains[i]));
                    if(idx==null){
                        return new int[0];
                    }
                    ans[idx]=rains[i];
                    set.remove(idx);
                }
                map.put(rains[i],i);
            }
        } 
        return ans;
    }
}