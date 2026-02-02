class Solution {
    public int maximumLength(String s) {
        int[][] pre = new int[26][s.length()];
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
                prev=arr[i];
                if(arr[i]>=3)ans=Math.max(ans,i+1);
            }
        }
        return ans;
    }
}
