class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int pref[] = pre(arr, target);
        int suff[] = suf(arr, target);
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            if(suff[i+1]!= Integer.MAX_VALUE && pref[i]!=Integer.MAX_VALUE){
                ans = Math.min(ans,pref[i]+suff[i+1]);
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    public int[] pre(int arr[], int tar){
        int n = arr.length;
        int ans[] = new int[n];
        int min = Integer.MAX_VALUE;
        int left=0;
        int sum=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];

            while(sum>=tar){
                if(sum==tar){
                    min = Math.min(right-left+1,min);
                }
                sum-=arr[left++];
            }
            ans[right]=min;

        }

        return ans;
    }

    public int[] suf(int arr[], int tar){
        int n = arr.length;
        int ans[] = new int[n];
        int min = Integer.MAX_VALUE;
        int right=n-1;
        int sum=0;
        for(int left=n-1;left>=0;left--){
            sum+=arr[left];

            while(sum>=tar){
                if(sum==tar){
                    min=Math.min(right-left+1,min);
                }
                sum-=arr[right--];
            }
            ans[left]=min;
        }

        return ans;
    }
}