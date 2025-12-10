class Solution {
    public int countPermutations(int[] complexity) {
        int mod = 1000000007;
        int first = complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(first>=complexity[i]){
                return 0;
            }
        }

        long fact=1;

        for(int i=complexity.length-1;i>=1;i--){
            fact= (fact*i)%mod;
        }

        return (int)fact;



    }
}