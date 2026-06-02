class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<landDuration.length;i++){
            for(int j=0;j<waterDuration.length;j++){
                int time = landStartTime[i]+landDuration[i];
                int water = Math.max(waterStartTime[j],time);
                time = water+waterDuration[j];
                ans=Math.min(ans,time);

                time = waterStartTime[j]+waterDuration[j];
                int land = Math.max(landStartTime[i],time);
                time = land+landDuration[i];
                ans=Math.min(ans,time);
            }

            
        }

        return ans;
    }
}