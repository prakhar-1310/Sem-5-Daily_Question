class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,0,0,dp);
    }

    public int helper(String word1, String word2, int i, int j, int dp[][]){
        if(i==word1.length()){
            return word2.length()-j;// required letter to be added
        }
        if(j==word2.length()){
            return word1.length()-i;// extra letter to be deleted
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        if(word1.charAt(i)==word2.charAt(j)){
            ans =helper(word1,word2,i+1,j+1,dp);
        }
        else{
            int del = helper(word1,word2, i+1,j,dp);
            int rep = helper(word1,word2, i+1,j+1,dp);
            int add = helper(word1,word2, i,j+1,dp);
            ans = Math.min(del,Math.min(rep,add))+1;
        }
        return dp[i][j]=ans;
    }
}