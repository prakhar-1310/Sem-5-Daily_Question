class Solution {
    private int hamming(String s1, String s2){
        int i = 0;
        int j = 0;
        int c = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)) c++;
            i++;
            j++;
        }
        return c;
    }
    
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        
        for(int i = 1; i < n; i++){
            hash[i] = i; // Initialize: points to itself (start of chain)
            for(int j = 0; j < i; j++){
                if(groups[i] != groups[j] && 
                   words[i].length() == words[j].length() && 
                   hamming(words[i], words[j]) == 1 && 
                   1 + dp[j] > dp[i]){
                    
                    dp[i] = 1 + dp[j];
                    hash[i] = j; // Track previous index in optimal chain
                }
            }
        }
        
        // Find maximum length and its ending index
        int max = -1;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }
        
        // Reconstruct the subsequence in reverse order
        List<String> ans = new ArrayList<>();
        ans.add(0, words[idx]);
        while(hash[idx] != idx){
            idx = hash[idx];
            ans.add(0, words[idx]);
        }
        return ans;
    }
}