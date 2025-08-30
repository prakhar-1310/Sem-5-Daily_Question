class Solution {
    public int missingNumber(int[] nums) {
        // for (int i =0; i<=nums.length; i++){
        //     int k =0;
        //     for (int j=0; j<nums.length;j++){
        //         if(i==nums[j]){
        //             k++;
        //         }
        //     }
        //     if (k==0){
        //         return i;
        //     }
        // }
        // return 0;

        int n =nums.length;
        int total = n*(n+1)/2; // sum of n consecutive integers
        int sum=0;
        for (int i :nums){
            sum+=i;
        }
        return total-sum;
    }
}