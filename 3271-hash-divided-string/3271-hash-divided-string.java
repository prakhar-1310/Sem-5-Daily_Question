class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int cnt=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=(s.charAt(i)-'a');
            cnt++;

            if(cnt==k){
                cnt=0;
                sb.append((char)('a'+sum%26));
                sum=0;
            }
        }

        return sb.toString();
    }
}