class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean dp[][] = new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length())return false; 
        return helper(0,0,s1,s2,s3,dp);
    }

    public boolean helper(int i, int j, String s1, String s2, String s3, Boolean dp[][]){
        if(i==s1.length() && j==s2.length()){
            return true;
        }
        int k = i+j;

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        boolean ans = false;

        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            boolean opt = helper(i+1,j,s1,s2,s3,dp);
            ans = ans || opt;
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            boolean opt = helper(i,j+1,s1,s2,s3,dp);
            ans = ans||opt;
        }

        return dp[i][j]=ans;
        
    }
}