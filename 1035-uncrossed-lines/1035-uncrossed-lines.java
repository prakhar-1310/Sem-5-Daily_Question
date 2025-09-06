class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return helperBU(nums1,nums2);
    }
    public static int helperBU(int nums1[],int nums2[]) { // Bottom UP
		int dp[][] = new int [nums1.length+1][nums2.length+1];
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				int ans =0;
				if(nums1[i-1]==nums2[j-1]) {
					ans = 1+ dp[i-1][j-1];
				}
				else {
					int f = dp[i-1][j];
					int s = dp[i][j-1];
					ans = Math.max(f, s);
				}
				dp[i][j]=ans;
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}