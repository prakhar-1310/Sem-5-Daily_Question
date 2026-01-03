class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>>map = new HashMap<>();
        for(int i=0;i<colors.length();i++){
            map.put(i,new ArrayList<>());
        }
        int indeg[] = new int[colors.length()];
        for(int e[] : edges){
            int v1 = e[0];
            int v2 = e[1];
            indeg[v2]++;
            if(v1==v2){
                return -1;
            }
            map.get(v1).add(v2);
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        int dp[][] = new int[colors.length()][26];
        int ans = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int rm = q.poll();
            count++;

            int idx = colors.charAt(rm)-'a';
            dp[rm][idx]++;
            ans = Math.max(ans,dp[rm][idx]);

            for(int ngbr : map.get(rm)){
                for(int i=0;i<26;i++){
                    dp[ngbr][i] = Math.max(dp[ngbr][i],dp[rm][i]);
                }
                indeg[ngbr]--;
                if(indeg[ngbr]==0){
                    q.add(ngbr);
                }
            }
        }
        

        return count==colors.length() ? ans :-1;
    }

    
}