class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum=0;
        int p=0;
        for(int i=happiness.length-1;i>=happiness.length-k;i--){
            sum+=Math.max(0,happiness[i]-p);
            p++;
        }
        return sum;
    }
}