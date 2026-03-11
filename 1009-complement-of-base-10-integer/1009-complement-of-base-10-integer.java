class Solution {
    public int bitwiseComplement(int n) {
        if (n==0){
            return 1;
        }
        // int mul = 1;
        // int source = 10;
        // int desti = 2;
        // int sum=0;
        // while (n>0){
        //     int rem = n%desti;
        //     sum=sum+rem*mul;
        //     n=n/desti;
        //     mul*=source;
        // }
        // int sum2=sum;
        // int dig =0;
        // while (sum2>0){
        //     sum2=sum2/10;
        //     dig++;
        // }
        // int setbit=0;
        // for (int i=1;i<=dig;i++){
        //     setbit=setbit*10+1;
        // }

        // int num = setbit-sum;
        // int ans=0;
        // desti = 10;
        // source =2;
        // mul=1;
        // while (num>0){
        //     int rem = num%desti;
        //     num/=desti;
        //     ans = ans + rem*mul;
        //     mul*=source;
        // }
        // return ans;

        int num=0;
        int pow=0;
        while(num<n){
            num+=(int)Math.pow(2,pow);
            pow++;
        }
        return num-n;
    }
}