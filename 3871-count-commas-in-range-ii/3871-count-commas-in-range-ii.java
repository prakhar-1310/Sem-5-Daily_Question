class Solution {
    public long countCommas(long n) {
        if(n<1000)return 0;

        long tot=0;
        long st = 1000;
        while(st<=n){
            int len = (st+"").length()-1;
            tot+=n-(st-1);
            st*=1000;
        }

        return tot;
    }
}