class Solution {
    public int MOD = (int) 1e9 + 7;
    public int ways(List<Integer>[] hats, int i, int allState, int state, int[][] dp) {
        // state define how many person satisfied
        if(state == allState) return 1;
        if(i >= hats.length) return 0;


        // main logic
        if(dp[i][state] >= 0) return dp[i][state];
        List<Integer> persons = hats[i];

        int count = ways(hats, i+1, allState, state, dp);

        for(int candidate : persons) {
            // check if bit is available
            int mask = 1 << (candidate-1);
            if((mask & state) == 0) {
                count = (count % MOD) + ways(hats, i+1, allState, mask | state, dp);
            }
        }

        return dp[i][state] = count % MOD;
    }
    public int numberWays(List<List<Integer>> persons) {
        
        // reverse this
        int n = persons.size();

        List<Integer>[] hats = new List[41];
        for(int i = 0; i < 41; i++) hats[i] = new ArrayList<>();

        for(int i = 0; i < persons.size(); i++) {
            for(int hat : persons.get(i)) {
                hats[hat].add(i+1);
            }
        }

        // now hat can be give list of persons 
        int allState = (1 << n) - 1;

        int[][] dp = new int[41][allState+1];
        for(int i = 0; i < 41; i++) {
            int[] temp = dp[i];
            Arrays.fill(temp, -1);
        }
        return ways(hats, 1, allState, 0, dp);
    }
}