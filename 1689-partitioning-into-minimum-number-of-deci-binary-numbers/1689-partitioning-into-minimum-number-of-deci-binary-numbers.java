class Solution {
    public int minPartitions(String n) {
        int cnt=0;
        while(n.length()!=0){
            cnt++;
            StringBuilder sb = new StringBuilder();
            for(char i : n.toCharArray()){
                if(i>='1'){
                    sb.append(i-'0'-1);
                }
                else{
                    sb.append('0');
                }
            }
            String str = sb.toString();
            int idx=0;
            while(idx<str.length() && str.charAt(idx)=='0'){
                idx++;
            }
            n=str.substring(idx);
        }

        return cnt;
    }
}