class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int a=1;
        int n=nums.length;
        int []pref=new int[n];
        pref[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]==1)
            {
                a++;
                pref[i]=a;
            }
            else{
                a=1;
                pref[i]=a;
            }
        }
        int []ans=new int[n];
        for(int i=0;i<n;i++)
        {
            if(pref[i]>=k)
                ans[i]=nums[i];
            else
                ans[i]=-1;
        }
        return Arrays.copyOfRange(ans,k-1,n);
    }
}