class Solution {
    int prime[] = new int[2*100000]; // zero means Prime
    int initiated=0;
    public int minOperations(int[] nums) {
        if(initiated==0){
            prime[0]=1;
            prime[1]=1;
            for(int i=2;i<prime.length;i++){
                if(prime[i]==1)continue;
                for(int j=i*2;j<prime.length;j+=i){
                    prime[j]=1;
                }
            }
            initiated = 1;
        }

        int tot=0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0){ // prime
                if(prime[nums[i]]==0){
                    continue;
                }
                else{
                    int opt1 = Integer.MAX_VALUE; 
                    for(int j=nums[i];j<prime.length;j++){
                        if(prime[j]==0){
                            opt1 = j-nums[i];
                            break;
                        }
                    }

                    tot+=opt1;
                }
            }
            else{ // non prime
                if(prime[nums[i]]==1){
                    continue;
                }
                else{
                    if(nums[i]==2){
                        tot+=2;
                    }
                    else{
                        tot+=1;
                    }
                }
            }
        }

        return tot;
    }
}