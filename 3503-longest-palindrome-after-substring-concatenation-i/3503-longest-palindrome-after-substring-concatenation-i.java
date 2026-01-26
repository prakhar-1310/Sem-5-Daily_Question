class Solution {
    public int longestPalindrome(String s, String t) {
        int n = s.length();  
        int m = t.length();  
        int maxLength = 0;   // Ans to be returned
        
        // dp[i][j] will represent the length of the longest palindromic subsequence
        // that starts at s[i] and ends at t[j-1].
        int[][] dp = new int[n+1][m+1];

        // Preprocessing for string s: 
        // p[i] stores the length of the longest palindrome starting at index i in string s.
        int[] p = new int[n+1];
        for (int i = 0; i < n; i++) {
            for(int j = n-1; j >= 0; j--) {
                if(isPal(s, i, j)) {  // If substring s[i..j] is a palindrome
                    p[i] = j - i + 1;  // Store the length of the palindrome starting at i
                    break;
                }
            }
        }

        // Preprocessing for string t:
        // q[i+1] stores the length of the longest palindrome ending at index i in string t.
        int[] q = new int[m+1];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(isPal(t, j, i)) {  // If substring t[j..i] is a palindrome
                    q[i+1] = i - j + 1;  // Store the length of the palindrome ending at i
                    break;
                }
            }
        }

        // dp[n][0] = 0 for the case when no element is taken from s or t

        // dp[n][i] means no elements are taken from string s but elements are taken from string t
        for (int i = 1; i <= m; i++) {
            dp[n][i] = q[i];  // Initialize the last row of dp using precomputed values from q
        }

        // dp[i][0] means no elements are taken from string t but elements are taken from string s
        for (int i = 0; i < n; i++) {
            dp[i][0] = p[i];  // Initialize the first column of dp using precomputed values from p
        }

        // Fill the dp table: 
        // Move in the left direction for s and right direction for t
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(p[i], q[j]);
                    dp[i][j] = Math.max(dp[i][j], 2 + dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(p[i], q[j]);
                }
                
                // Keep track of the maximum palindrome length found so far
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    // Helper method to check if a substring from index i to j in string s is a palindrome
    private boolean isPal(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}