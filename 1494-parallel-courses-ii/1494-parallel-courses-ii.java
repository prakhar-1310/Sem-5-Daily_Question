import java.util.*;

class Solution {
    public int minNumberOfSemesters(int n,int[][] relations,int k){
        int[] pre=new int[n];
        for(int[] e:relations) pre[e[1]-1]|=1<<(e[0]-1);

        int N=1<<n,INF=1_000_000;
        int[] dp=new int[N];
        Arrays.fill(dp,INF);
        dp[0]=1; 
        for(int mask=0;mask<N;mask++){
            if(dp[mask]==INF) continue;
            if(mask==N-1) continue;

            int avail=0;
            for(int i=0;i<n;i++){
                if(((mask>>i)&1)==0 && (pre[i]&mask)==pre[i]) avail|=1<<i;
            }
            int cnt=Integer.bitCount(avail);
            if(cnt==0) continue;

            if(cnt<=k){
                int next=mask|avail;
                dp[next]=Math.min(dp[next],dp[mask]+1);
            }else{
                for(int sub=avail;sub>0;sub=(sub-1)&avail){
                    if(Integer.bitCount(sub)==k){
                        int next=mask|sub;
                        dp[next]=Math.min(dp[next],dp[mask]+1);
                    }
                }
            }
        }
        return dp[N-1]-1;
    }
}

