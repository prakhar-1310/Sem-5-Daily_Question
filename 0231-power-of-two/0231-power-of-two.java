class Solution {
    public boolean isPowerOfTwo(int n) {
        // int i =0 ;
        // int sum=0;
        // while(n>=sum){
        //     sum = (int)(Math.pow(2,i));
        //     if (sum==n){
        //         return true;
        //     }
        //     i++;
        // }
        // return false;



        if (n==0){
            return false;
        }
        while(n!=1){
            int rem =n%2;
            n/=2;
            if (rem!=0){
                return false;
            }
        }
        return true;
    }
}