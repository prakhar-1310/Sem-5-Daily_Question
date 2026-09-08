class Solution {
    long mod = 1000000007;
    public int colorTheGrid(int m, int n) {
        List<String>list=new ArrayList<>();
        col1("", m, list);

        long dp[][] = new long[list.size()][n];
        for(long i[] : dp){
            Arrays.fill(i, -1);
        }

        long tot=0;
        for(int i=0;i<list.size();i++){
            tot= (tot+helper(i, n-1, list, dp))%mod;
        }

        return (int)((tot+mod)%mod);
    }

    public long helper(int prevInd, int colLeft, List<String>list, long dp[][]){
        if(colLeft==0)return 1;

        if(dp[prevInd][colLeft]!=-1){
            return dp[prevInd][colLeft];
        }

        String prev=list.get(prevInd);

        long ans=0;
        for(int i=0;i<list.size();i++){
            if(prevInd==i)continue;
            String curr = list.get(i);
            int flag=0;
            for(int j=0;j<prev.length();j++){
                if(curr.charAt(j)==prev.charAt(j)){
                    flag=1;
                    break;
                }
            }

            if(flag==0){
                long temp =helper(i, colLeft-1, list, dp)%mod;
                ans = (ans+temp)%mod;
            }
        }

        return dp[prevInd][colLeft]=ans;
    }

    public void col1(String ans, int m, List<String>list){
        if(ans.length()==m){
            list.add(ans);
            return;
        }

        if(ans.length()==0){
            col1(ans+"R", m, list);
            col1(ans+"G", m, list);
            col1(ans+"B", m, list);
        }
        else if(ans.charAt(ans.length()-1)=='R'){
            col1(ans+"G", m, list);
            col1(ans+"B", m, list);
        }
        else if(ans.charAt(ans.length()-1)=='G'){
            col1(ans+"R", m, list);
            col1(ans+"B", m, list);
        }
        else if(ans.charAt(ans.length()-1)=='B'){
            col1(ans+"G", m, list);
            col1(ans+"R", m, list);
        }
    }
}