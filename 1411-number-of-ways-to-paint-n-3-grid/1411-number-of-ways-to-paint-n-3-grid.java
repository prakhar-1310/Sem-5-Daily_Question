class Solution {
    long mod = 1000000007;
    public int numOfWays(int n) {
        int row = n;
        int col = 3;
        List<String>list=new ArrayList<>();
        row1("", col, list);

        long dp[][] = new long[list.size()][row];
        for(long i[] : dp){
            Arrays.fill(i, -1);
        }

        long tot=0;
        for(int i=0;i<list.size();i++){
            tot= (tot+helper(i, row-1, list, dp))%mod;
        }

        return (int)((tot+mod)%mod);
    }

    public long helper(int prevInd, int rowLeft, List<String>list, long dp[][]){
        if(rowLeft==0)return 1;

        if(dp[prevInd][rowLeft]!=-1){
            return dp[prevInd][rowLeft];
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
                long temp =helper(i, rowLeft-1, list, dp)%mod;
                ans = (ans+temp)%mod;
            }
        }

        return dp[prevInd][rowLeft]=ans;
    }

    public void row1(String ans, int col, List<String>list){
        if(ans.length()==col){
            list.add(ans);
            return;
        }

        if(ans.length()==0){
            row1(ans+"R", col, list);
            row1(ans+"G", col, list);
            row1(ans+"B", col, list);
        }
        else if(ans.charAt(ans.length()-1)=='R'){
            row1(ans+"G", col, list);
            row1(ans+"B", col, list);
        }
        else if(ans.charAt(ans.length()-1)=='G'){
            row1(ans+"R", col, list);
            row1(ans+"B", col, list);
        }
        else if(ans.charAt(ans.length()-1)=='B'){
            row1(ans+"G", col, list);
            row1(ans+"R", col, list);
        }
    }
}