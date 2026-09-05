class Solution {
    public long maximumPoints(int[] enemy, int curr) {
        Arrays.sort(enemy);
        long min = enemy[0];
        if(curr==0 || min>curr)return 0;
        long sum=curr;
        for(int i=1;i<enemy.length;i++){
            sum+=enemy[i];
        }

        return sum/min;
    }
}