class Solution {
    public double myPow(double x, int n) {
        // return (double)(Math.pow(x,n));
        double N = n;
        if(N<0){
            N=-N;
            x=1/x;
        }
        return helper(x,N);
        
    }
    public static double helper(double x, double n){
        if (n==0){
            return 1;
        }
        double a = helper(x,n-1);
        return a*x;
    }
}