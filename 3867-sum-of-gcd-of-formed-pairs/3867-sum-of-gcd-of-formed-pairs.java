class Solution {
    public long gcdSum(int[] nums) {
        int arr[] = new int[nums.length];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            arr[i]=gcd(max, nums[i]);
        }

        long sum=0;
        Arrays.sort(arr);
        
        int i=0;
        int j=nums.length-1;

        while(i<j){
            sum+=gcd(arr[i++],arr[j--]);
        }

        return sum;
    }

    public int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}