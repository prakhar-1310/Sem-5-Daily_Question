class Solution {
    public double myPow(double x, int n) {
        // return (double)(Math.pow(x,n));
        long N = n;
        if(N<0){
            N=-N;
            x=1/x;
        }
        return helper(x,N);
        
    }
    public static double helper(double x, long n){
        if (n==0){
            return 1;
        }
        double half = helper(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}