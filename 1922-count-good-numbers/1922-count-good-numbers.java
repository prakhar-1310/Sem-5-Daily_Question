class Solution {
    public int countGoodNumbers(long n) {
        long evenbase =5;
        long oddbase = 4;
        long mod = 1000000007;
        long even = helper(evenbase,n-(n/2),mod);
        long odd = helper(oddbase,(n/2),mod);
        return (int)((even*odd)%mod);
    }
    public static long helper(long base, long n, long mod){
        if(n==0){
            return 1;
        }
        long half = helper(base, n/2,mod)%mod;

        if(n%2==0){
            return (half*half)%mod;
        }
        else{
            return (((half*half)%mod)*base)%mod;
        }
    }
}