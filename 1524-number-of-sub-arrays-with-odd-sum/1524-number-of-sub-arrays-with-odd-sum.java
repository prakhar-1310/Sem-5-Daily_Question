class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans=0;
        long mod = 1000000007;
        
        int odd=0;
        int even=1;
        int sum=0;

        for(int i : arr){
            sum+=i;
            
            if(sum%2==0){ // even, need odd to be substracted
                ans = (ans + odd)%mod;
                even++;
            }
            else{
                ans = (ans + even)%mod;
                odd++;
            }
        }

        return (int)ans;
        
    }
}