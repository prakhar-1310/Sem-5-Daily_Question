class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double low = 0;
        double high = 1.0;

        while(low<=high){
            double mid = low + (high-low)/2;

            Pair p = helper(arr, mid);

            if(p.cnt == k){
                return new int[]{p.num, p.deno};
            }

            if(p.cnt>k){
                high=mid;
            }
            else{
                low = mid;
            }
        }

        return null;
    }

    public Pair helper(int arr[], double value){
        int num=arr[0];
        int den=arr[arr.length-1];
        int i=0;
        int cnt=0;
        for(int j=1;j<arr.length; j++){
            while(1.0*arr[i]/arr[j]<=value){
                i++;
            }
            cnt+=i;

            if(i>0 && 1.0*arr[i-1]/arr[j] > 1.0*num/den){
                num=arr[i-1];
                den=arr[j];
            }
        }

        return new Pair(cnt, num, den);
    }

    class Pair{
        int cnt;
        int num;
        int deno;

        public Pair(int cnt, int n, int d){
            this.cnt=cnt;
            this.num=n;
            this.deno=d;
        }
    }
}