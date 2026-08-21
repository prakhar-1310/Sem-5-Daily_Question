class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = 1L*n*Math.min(a,Math.min(b,c));
        long ans=-1;

        while(left<=right){
            long mid = left + (right-left)/2;

            if(check(a,b,c,n,mid)){
                ans = mid;
                right = mid-1;
            }
            else{
                left=mid+1;
            }
        }

        return (int)ans;
    }

    public boolean check(int a, int b, int c, int n, long val){
        long cnt=0;
        cnt+= val/a;
        cnt+= val/b;
        cnt+= val/c;
        cnt-= val/lcm(a,b);
        cnt-= val/lcm(b,c);
        cnt-= val/lcm(c,a);
        cnt+= val/lcm(a,lcm(b,c));

        return cnt>=n;
    }

    public long lcm(long a, long b){
        return a*b / gcd(a,b);

    }

    public long gcd(long a, long b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }

    
}