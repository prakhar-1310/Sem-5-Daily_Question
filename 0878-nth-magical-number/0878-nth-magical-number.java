class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000000007;

        long left = 2;
        long right = 1L*n*Math.min(a,b);
        long lcm = lcm(a,b);
        long ans=-1;

        while(left<=right){
            long mid = left + (right-left)/2;

            if(check(a,b,n,mid,lcm)){
                ans = mid;
                right = mid-1;
            }
            else{
                left=mid+1;
            }
        }

        return (int)(ans%mod);
    }

    public boolean check(int a, int b, int n, long val, long lcm){
        long cnt=0;
        cnt+= val/a;
        cnt+= val/b;
        cnt-= val/lcm;

        return cnt>=n;
    }

    public long lcm(int a, int b){
        return 1L*a*b / gcd(a,b);

    }

    public long gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}