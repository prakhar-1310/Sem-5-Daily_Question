class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int a[] = new int[101];
        int res[] = new int[n - k + 1];
        for (int i=0;i<k;i++)
        {
            a[nums[i]+50]++;
        }
        for (int i=0;i<=n-k;i++)
        {
            int count=0,val=-1;
            for(int j=0;j<=49;j++)
            {
                if(a[j]>0)
                {
                    count+=a[j];
                    if(count>=x)
                    {
                        val=j;
                        break;
                    }
                }
            }
            a[nums[i]+50]--;
            if(i<n-k)
            {
                a[nums[i+k]+50]++;
            }
            res[i] = val == -1 ? 0 : val-50;
        }
        return res;
    }
}