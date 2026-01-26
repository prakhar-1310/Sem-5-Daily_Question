class Solution {
    public int longestPalindrome(String s, String t) {
        t = new StringBuilder(t).reverse().toString();
        
        int[] ss = lps(s), tt = lps(t);
        int n = s.length(), m = t.length(), res = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int a = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j]+1;
                    a = 1;
                }
                res = Math.max(res, 2*dp[i+1][j+1] + Math.max(ss[i+a], tt[j+a]));
            }
        }
        return res;
    }

    

    private int[] lps(String s) {
        int n = s.length(), res[] = new int[n+1];
        for (int i = 0; i < n; ++i) {
            for (int j = n-1; j >= i && res[i] < 2; --j) {
                if (isPalindrome(s, i, j)) {
                    res[i] = j-i+1;
                } else {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
    
    
    private boolean isPalindrome(String s, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}