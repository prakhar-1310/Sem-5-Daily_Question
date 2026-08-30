class Solution {
    public int sumDecoded(long[] nums) {
        long mod = 1000000007;
        long ans=0;
        for(long i : nums){
            int wid = (int)(i%10);
            long d = i/10;
            long x = Long.parseLong((d+"").substring(0,wid));
            long y = Long.parseLong((d+"").substring(wid));

            ans = (ans + helper(x,y,mod))%mod;
        }

        return (int)ans;
    }

    public long helper(long x, long y, long mod){
        long res=1;
        x%=mod;
        while(y>0){

            if((y&1)==1){
                res = (res*x)%mod;
            }

            x = (x*x)%mod;
            y>>=1;
        }

        return res;
    }
}