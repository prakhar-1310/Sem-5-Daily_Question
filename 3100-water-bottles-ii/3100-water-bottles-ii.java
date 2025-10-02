class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emp=0;
        int full=numBottles;
        int exc = numExchange;
        int ans=0;
        while(full>0){
            ans+=full;
            emp+=full;
            full=0;
            while(emp>=exc){
                emp-=exc;
                full++;
                exc++;
            }
        }
        return ans;
    }
}