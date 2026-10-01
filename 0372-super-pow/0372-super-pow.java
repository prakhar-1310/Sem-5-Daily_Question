class Solution {
    public int superPow(int a, int[] b) {
        if(a==1)return 1;
        long ans=1;
        long mod = 1337;
        int n = b.length;
        

        for(int i=0;i<n-1;i++){
            long temp = power(a, b[i], mod);
            ans = (ans*temp)%mod;
            ans = power(ans,10,mod);
        }

        

        return (int)((ans*power(a,b[n-1],mod))%mod);
    }

    public long power(long a, long b, long mod){
        long ans=1;

        while(b>0){

            if((b&1)==1){
                ans = (ans*a)%mod;
            }

            a = (a*a)%mod;

            b>>=1;
        }

        return ans;
    }
}