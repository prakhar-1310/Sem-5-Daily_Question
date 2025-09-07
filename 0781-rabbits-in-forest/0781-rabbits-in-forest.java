class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map = new HashMap<>();//x,count
        for(int i : answers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        double ans=0;
        for(int x : map.keySet()){
            double count = map.get(x);
            double group_size = x+1;
            double group =Math.ceil(count/group_size);
            ans+=group*group_size;
        }
        return (int)ans;
        
    }
}