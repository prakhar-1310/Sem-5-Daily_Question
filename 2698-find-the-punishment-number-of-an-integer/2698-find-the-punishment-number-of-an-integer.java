class Solution {
    public int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            if(helper(i*i+"", i, 0, 0)){
                sum+=(i*i);
            }
        }
        return sum;
    }

    public boolean helper(String sq, int n, int ind, int sum){
        if(ind>=sq.length() && sum==n){
            return true;
        }

        for(int i=ind+1; i<=sq.length(); i++){
            int val = Integer.parseInt(sq.substring(ind, i));
            boolean bol = helper(sq, n, i, sum+val);
            if(bol)return true;
        }

        return false;
    }
}