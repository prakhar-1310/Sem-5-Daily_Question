class Solution {
    public int minCost(int n) {
        int sum=0;
        for(int i=2;i<=n;i++){
            sum+=i-1;
        }
        return sum;
    }
}