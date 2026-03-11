class Solution {
    public int compress(char[] chars) {
        int cnt=1;
        char prev = chars[0];
        int ans=0;
        int idx=0;
        for(int i=1;i<chars.length;i++){
            char ch = chars[i];
            if(prev==ch){
                cnt++;
            }
            else{
                ans++;
                chars[idx++]=prev;
                if(cnt!=1){
                    ans+=(cnt+"").length();
                    int j=(cnt+"").length();
                    int temp = j;
                    while(cnt>0){
                        chars[idx+j-1]=(char)(cnt%10+'0');
                        cnt/=10;
                        j--;
                    }
                    idx+=temp;
                }
                cnt=1;
                prev=ch;
            }
        }

        ans++;
                chars[idx++]=prev;
                if(cnt!=1){
                    ans+=(cnt+"").length();
                    int j=(cnt+"").length();
                    while(cnt>0){
                        chars[idx+j-1]=(char)(cnt%10+'0');
                        cnt/=10;
                        j--;
                    }
                }

        return ans;
    }
}