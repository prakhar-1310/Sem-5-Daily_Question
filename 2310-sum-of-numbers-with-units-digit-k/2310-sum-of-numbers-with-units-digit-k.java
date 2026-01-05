class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0){
            return 0;
        }
        for(int i=1;i<=10;i++){
            if((num-(i*k))%10==0 && i * k <= num){
                return i;
            }
        }

        return -1;
    }
    // k=9 // num
    // let two terms => x9,y9
    // x*10+9 + y*10+9 = num
    // x*10 + y*10 + k*i = num// i is no of elements in a set mean i = no. of k
    // (num-k*i)%10=x+y
    // since x and y are integer
    // therefore (num-k*i)%10==0

    // And 
    // k*i<=num
    
}