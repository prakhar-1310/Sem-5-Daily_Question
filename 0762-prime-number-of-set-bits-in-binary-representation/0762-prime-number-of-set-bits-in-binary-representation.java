class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i = left;i<=right;i++){
            int setbit=0;
            int n =i;
            while(n>0){
                if((n&1)==1){
                    setbit++;
                }
                n = (n>>1);
            }
            if(prime(setbit)){
                System.out.println(i+" "+setbit);
                cnt++;
            }
        }

        return cnt;
    }

    public boolean prime(int n){
        if(n==1)return false;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}