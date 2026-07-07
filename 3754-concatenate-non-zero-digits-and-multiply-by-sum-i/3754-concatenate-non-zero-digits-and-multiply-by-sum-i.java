class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long num=0;
        for(char ch : (n+"").toCharArray()){
            if(ch!='0'){
                num = num*10+(ch-'0');
                sum+=(ch-'0');
            }
        }

        return num*sum;
    }
}