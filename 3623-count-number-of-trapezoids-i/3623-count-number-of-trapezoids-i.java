class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Long>map = new HashMap<>();
        for(int i[] : points){
            int x=i[0];
            int y=i[1];

            map.put(y,map.getOrDefault(y,0L)+1);
        }
        long tot=0;
        long prev=0;

        for(long i : map.values()){
            long num = i*(i-1)/2;
            long temp=(num*prev)%1000000007;
            tot=(tot+temp)%1000000007;
            prev=(prev+num);
        }

        return (int)(tot%1000000007);
    }

    
}