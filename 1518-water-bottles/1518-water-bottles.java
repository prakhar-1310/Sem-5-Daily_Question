class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int tot=0;
        int emp=0;
        while(numBottles>0){
            tot+=numBottles;
            int newEmp = (numBottles+emp)%numExchange;
            numBottles = (numBottles+emp)/numExchange;
            emp=newEmp;
        }

        return tot;
    }
}