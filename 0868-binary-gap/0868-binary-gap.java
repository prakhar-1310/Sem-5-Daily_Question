class Solution {
    public int binaryGap(int n) {
        int ans=0;
        int cnt=1;
        boolean flag = false;
        while(n>0){
            if((n&1)==1){
                if(flag){
                    ans = Math.max(ans,cnt);
                }
                cnt=1;
                flag=true;
            }
            else{
                cnt++;
            }
            n>>=1;
        }
        return ans;
        
    }
}