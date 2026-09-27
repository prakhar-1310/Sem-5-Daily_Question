class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int rem = n;
        int left=1;
        int step=1;
        while(rem>1){
            if(left==1 || rem%2!=0){
                head+=step;
                if(left==1)left=-1;
                else left=1;
            }
            else{
                left=1;
            }
            step*=2;
            rem/=2;
        }

        return head;
    }
}