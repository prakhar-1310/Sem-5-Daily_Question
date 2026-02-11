class Solution {
    long [][][] dp;
    int mod = (int)1e9+7;
    int k;
    public int countKReducibleNumbers(String s, int k) {
        this.k = k;
        char [] a = s.toCharArray();
        int n= a.length;
        dp = new long[2][n+1][n+1];
        for (int i = 0; i <=n; i++) {
            Arrays.fill(dp[0][i], -1);
            Arrays.fill(dp[1][i], -1);

        }
        int cntOfOne=0;
        for(char c : a){
            if(c=='1')cntOfOne++;
        }
        return (int)((solve(a,0,0,0)-isReducible(cntOfOne)+mod)%mod);
    }
    
    // to check if the number n can be reduced within k steps.
    int isReducible(int n){
        if(n==0)return 0;
        int cnt =1; //cnt =1, because n is the number of bit of the number that will be formed from the string.
                    // e.g 10011 count will be three but original number is 19. so one operation is already performed. that's why cnt = 1;
        while (n>1){
            cnt++;
            n = Integer.bitCount(n);
        }
        return cnt<=k?1:0;
    }

    
    long solve(char [] a ,int i,int cnt,int taken){
        if(i==a.length){
            return isReducible(cnt);
        }
        if(dp[taken][i][cnt]!=-1) return dp[taken][i][cnt];
        long ans=0;
        
        // taken = 1 represent that one of the bit is flipped from one to zero.
        // taken = 0 represent that no change has been done yet.
        if(taken==0){
            if(a[i]=='1'){
                ans+=solve(a,i+1,cnt+1,0); // take the bit as it is
                ans+=solve(a,i+1,cnt,1); // change it to zero. and mark the one bit has been flipped by setting taken =1.
            }else{
                ans+=solve(a,i+1,cnt,0); // you can't change.
            }
        }else{
            if(a[i]=='1') {
                ans += solve(a, i + 1, cnt + 1, 1); // take it as it is
            }else{
                ans+=solve(a,i+1,cnt+1,taken); // change 0 to 1.
            }
            ans+=solve(a,i+1,cnt,taken); // change it 0
        }
        return dp[taken][i][cnt] = ans%mod;
    }
}