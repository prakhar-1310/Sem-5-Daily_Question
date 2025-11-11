class Solution {
    public int findMaxForm(String[] strs, int m, int n){
        int dp[][][] = new int [strs.length][n+1][m+1];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return helper(strs,m,n,0,0,0,dp);
    }

    public int helper(String arr[],int m,int n,int one, int zero, int i,int dp[][][]){
        if(i==arr.length || one>n || zero>m){
            return 0;
        }
        if(dp[i][one][zero]!=-1){
            return dp[i][one][zero];
        }

        int o=0;
        int z=0;
        for(char ch : arr[i].toCharArray()){
            if(ch=='1'){
                o++;
            }
            else{
                z++;
            }
        }

        int inc=0;
        if(zero+z<=m && one+o<=n){
            inc = 1+ helper(arr,m,n,one+o,zero+z,i+1,dp);
        }
        int exc = helper(arr,m,n,one,zero,i+1,dp);

        return dp[i][one][zero] = Math.max(inc,exc);
    } 
}