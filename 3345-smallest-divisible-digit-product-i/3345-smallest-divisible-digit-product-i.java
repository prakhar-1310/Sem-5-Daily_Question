class Solution {
    public int smallestNumber(int n, int t) {
        int i=0;
        int mul=1;
        int num=n;
        while(num>0){
            mul*=num%10;
            num/=10;
        }
        while (mul%t!=0){
            num=n+i;
            mul=1;
            while(num>0){
                int rem = num%10;
                num/=10;
                mul*=rem;
            }
            if(mul%t==0){
                return n+i;
            }
            i++;
        }
        return n;
    }
}