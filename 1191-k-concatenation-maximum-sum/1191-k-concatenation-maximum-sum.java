class Solution {
    int mod = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k){
        if(k==1){
            return Kadanes(arr);
        }
        long sum=0;
        for(int i : arr){
            sum = (sum+i)%mod;
        }

        int newarr[] = new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            newarr[i] = arr[i];
        }
        for(int i=0;i<arr.length;i++){
            newarr[i+arr.length] = arr[i];
        }

        if(sum<=0){
            return Kadanes(newarr);
        }

        return (Kadanes(newarr) + (int)(((k-2)*sum)%mod))%mod;

    }

    public int Kadanes(int arr[]){
        long ans=0;
        long sum=0;
        for(int i : arr){
            sum+=i;
            ans = Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }      
        }
        return (int)ans%mod;
    }
}