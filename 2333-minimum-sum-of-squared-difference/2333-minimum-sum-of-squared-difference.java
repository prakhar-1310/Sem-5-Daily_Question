class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long)k1 + k2;

        int arr[] = new int [100001];

        for(int i=0;i<nums1.length;i++){
            arr[Math.abs(nums1[i]-nums2[i])]++;
        }

        for(int i =100001-1;i>0;i--){
            if(k<arr[i]){
                arr[i-1]+=k;
                arr[i]-=k;
                break;
            }
            else{
                arr[i-1]+=arr[i];
                k-=arr[i];
                arr[i]=0;
            }
        }
        long sum=0;

        for(int i=1;i<arr.length;i++){
            long d = i;
            long freq = arr[i];
            sum+=d*d*freq;
        }

        return sum;
    }
}