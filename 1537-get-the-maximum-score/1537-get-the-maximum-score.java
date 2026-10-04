class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long tot=0;
        long mod = 1000000007;
        int i = 0;
        int n = nums1.length;
        int j = 0;
        int m = nums2.length;

        long sum1=0;
        long sum2=0;

        int maxi=0;
        int maxj=0;

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                sum1+=nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j]){
                sum2+=nums2[j];
                j++;
            }
            else{
                tot=(tot+Math.max(sum1, sum2))%mod;
                tot=(tot+nums1[i])%mod;
                i++;
                j++;
                sum1=0;
                sum2=0;
                maxi=i;
                maxj=j;
            }
            
        }

        sum1=0;
        sum2=0;

        while(maxi<n){
            sum1+=nums1[maxi++];
        }

        while(maxj<m){
            sum2+=nums2[maxj++];
        }

        return (int)((tot+Math.max(sum1, sum2))%mod);
    }
}