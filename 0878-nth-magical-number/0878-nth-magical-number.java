class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1000000007;

        long left = 2;
        long right = 1L*n*Math.min(a,b);
        long lcm = lcm(a,b);
        System.out.println(lcm);
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

        System.out.println(ans);

        return (int)(ans%mod);
    }

    public boolean check(int a, int b, int n, long val, long lcm){
        int cnt=0;
        cnt+= val/a;
        cnt+= val/b;
        cnt-= val/lcm;

        return cnt>=n;
    }

    public long lcm(int a, int b){
        long max = Math.max(a,b);
        long min = Math.min(a,b);
        long tem = max;
        int i=2;
        while(max%min!=0){
            max = tem*i;
            i++;
        }

        return max;

    }
}