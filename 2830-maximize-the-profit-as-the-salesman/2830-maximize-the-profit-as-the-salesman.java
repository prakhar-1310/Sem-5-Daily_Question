class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a,b)->{
            return Integer.compare(a.get(0),b.get(0));
        });
        int dp[] = new int[offers.size()];
        Arrays.fill(dp, -1);

        return helper(0, offers, dp);
    }

    public int helper(int i, List<List<Integer>>offers, int dp[]){
        if(i>=offers.size()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        // skip
        int ans= helper(i+1, offers, dp);

        // take
        int next = bs(offers.get(i).get(1), i+1, offers);
        int take = offers.get(i).get(2) + helper(next, offers, dp);
        ans = Math.max(ans, take);
        
        return dp[i] = ans;
    }

    public int bs(int end, int low, List<List<Integer>>offers){
        int high = offers.size()-1;
        int ans = high+1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(offers.get(mid).get(0)<=end){
                low=mid+1;
            }
            else{
                high=mid-1;
                ans = mid;
            }
        }

        return ans;
    }
}