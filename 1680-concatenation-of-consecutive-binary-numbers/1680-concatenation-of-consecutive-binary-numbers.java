class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;

        long ans=0;
        for(int i=1;i<=n;i++){
            ans = ((ans<<len(i))%mod+i)%mod;
        }

        return (int)ans;
    }

    public int len(int n){
        int l=0;
        while(n>0){
            l++;
            n=(n>>1);
        }
        return l;
    }
}