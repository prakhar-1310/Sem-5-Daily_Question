class Solution {
    public int maximumLength(String s) {
        int[][] pre = new int[26][s.length()+1];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int j=i+0;
            
            while(j<s.length() && c==s.charAt(j)){
                pre[c-'a'][j-i]++;
                j++;
            }
            
            i=j-1;
        }
        int ans=-1;
        for(int[] arr:pre){
            int prev=0;
            for(int i=s.length()-1;i>-1;i--){
                arr[i]+=prev;
                prev=arr[i]+0;
                if(arr[i]>=3)ans=Math.max(ans,i+1);
            }
        }
        return ans;
    }
}


---


class Solution {
    public int maximumLength(String s) {
        int[][] pre = new int[26][3];
        for(int [] r:pre)Arrays.fill(r,-1);
        char prev = '0';
        int len  = 0;
        for(char c:s.toCharArray()){
            if(prev==c){
                len++;
            }
            else {
                len = 1;
                prev = c;
            }
            int j = c-'a';
            int min = Math.min(pre[j][0],Math.min(pre[j][1],pre[j][2]));
            if(len>min){
                if(min==pre[j][0]){
                    pre[j][0]=len+0;
                }
                else if(min==pre[j][1]){
                    pre[j][1]=len+0;
                }
                else pre[j][2]=len+0;
            }
        }

        int ans = -1;
        for(int [] r:pre){
            ans = Math.max(ans,Math.min(r[0],Math.min(r[1],r[2])));
        }
        return ans;
    }
}