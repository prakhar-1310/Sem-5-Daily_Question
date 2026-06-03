class Solution {
    public int earliestFinishTime(int[] lS, int[] lD, int[] wS, int[] wD) {
        return Math.min(helper(lS,lD,wS,wD), helper(wS,wD,lS,lD));
    }

    public int helper(int ls[], int ld[], int ws[], int wd[]){
        int mini=Integer.MAX_VALUE;

        for(int i=0; i<ls.length; i++){
            mini = Math.min(mini, ls[i]+ld[i]);
        }

        int result=Integer.MAX_VALUE;

        for(int i=0;i<ws.length;i++){
            int time = Math.max(mini,ws[i])+wd[i];
            result = Math.min(result, time);
        }

        return result;
    }
}