class Solution {
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }

        money-=children;

        int count = Math.min(money/7, children);

        money-=7*count;

        children-=count;

        if(children==1 && money==3){
            count--;
        }

        if (children == 0 && money > 0) {
            count--;
        }


        return count;
    }
}