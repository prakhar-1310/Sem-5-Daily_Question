class Solution {
    public int maximizeWin(int[] arr, int k) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for(int i = 1, j = 0; i<n; i++){
            while(arr[i]-arr[j] > k){
                j++;
            }
            left[i] = Math.max(left[i-1],(i-j+1));
        }

        right[n-1] = 1;
        for(int i = n-2, j = n-1; i>=0; i--){
            while(arr[j]- arr[i] > k){
                j--;
            }
            right[i] = Math.max(right[i+1],(j-i+1));
        } 

        int ans = 0;
        for(int i = 0; i<=n; i++){
            ans = Math.max(ans,((i == 0) ? 0 : left[i-1]) + ((i == n) ? 0 : right[i]));
        }
        return ans;
    }
}