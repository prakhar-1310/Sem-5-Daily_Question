class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->{
           return a[0]-b[0];
        });

        long tot=0;

        for(int i : robot){
            long dist=Integer.MAX_VALUE;
            int idx=-1;
            for(int j=0;j<factory.length;j++){
                if(factory[j][1]==0)continue;
                long temp = Math.abs(factory[j][0]-i);
                if(temp<dist){
                    idx=j;
                    dist=temp;
                }
            }

            tot+=dist;
            factory[idx][1]--;
        }

        return tot;
    }
}