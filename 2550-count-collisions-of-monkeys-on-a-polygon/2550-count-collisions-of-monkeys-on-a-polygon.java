class Solution {
    int mod = 1000000007;
    public int monkeyMove(int n) {
        long res = helper(2,n);
        return (int)((res-2+mod)%mod);
    }
    public long helper(int base, int n){
        if(n == 0){
            return 1;
        }
        long h = helper(base,n/2);
        long res = (h*h)%mod;
        if(n % 2 == 1){
            res = (res*base)%mod;
        }
        return res;
    }
}