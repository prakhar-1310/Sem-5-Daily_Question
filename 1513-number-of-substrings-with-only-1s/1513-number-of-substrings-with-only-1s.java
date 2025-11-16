class Solution {
    public int numSub(String s) {
        long count =0;
        long ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                long temp=((count+1)*count)/2;
                ans+= temp%1_000_000_007;
                count=0;
            }
        }
        long temp=((count+1)*count)/2;
        ans= (ans+temp)%1_000_000_007;
        return (int)ans;
    }
}