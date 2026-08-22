class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum=0;
        int mul=1;
        while(num>0){
            sum+=num%10;
            mul*=num%10;
            num/=10;
        }
        if(n % (sum+mul)==0){
            return true;
        }
        return false;
    }
}