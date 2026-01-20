class Solution {
    public int numTeams(int[] rating) {
        int dp[][][] = new int[rating.length][4][rating.length];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        int inc = helper(0,rating,0,-1,dp);
        
        dp= new int[rating.length][4][rating.length];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        int rev[] = new int[rating.length];
        int k=0;
        for(int i=rating.length-1;i>=0;i--){
            rev[k++]=rating[i];
        }

        int dec = helper(0,rev,0,-1,dp);

        return inc+dec;
    }

    public int helper(int i, int arr[], int cnt, int pInd, int dp[][][]){
        if(cnt==3){
            return 1;
        }
        if(i>=arr.length){
            return 0;
        }

        if(dp[i][cnt][pInd+1]!=-1){
            return dp[i][cnt][pInd+1];
        }

        int inc=0;
        if(pInd==-1 || arr[pInd]<arr[i]){
            inc = helper(i+1,arr,cnt+1,i,dp);
        }

        int exc = helper(i+1,arr,cnt,pInd,dp);

        return dp[i][cnt][pInd+1]=inc+exc;
    }
}