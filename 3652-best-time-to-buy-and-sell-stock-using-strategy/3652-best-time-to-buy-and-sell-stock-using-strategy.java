class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int len = prices.length;

        long profit = 0;
        long preSt[] = new long[len+1];
        long prePr[] = new long[len+1];

        for(int i=0;i<len;i++){
            long val = 1l * strategy[i]*prices[i];
            profit+=val;
            preSt[i+1]= preSt[i] + val;
            prePr[i+1]=prePr[i]+prices[i];
        }

        long max =0 ;
        for(int l=0;l+k<=len;l++){
            int mid = l + k/2;
            int r = l+k;

            long leftLoss = -(preSt[mid] - preSt[l]);

            long rightGain = (prePr[r]-prePr[mid])-
                            (preSt[r]-preSt[mid]);

            long gain = leftLoss + rightGain;
            max=Math.max(max,gain);
        }
        return profit+max;
    }
}