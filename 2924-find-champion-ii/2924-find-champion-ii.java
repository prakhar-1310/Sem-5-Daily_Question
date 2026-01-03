class Solution {
    public int findChampion(int n, int[][] edges) {
        int indeg[] = new int[n];

        for(int i[] : edges){
            int v1 = i[0];
            int v2 = i[1];

            indeg[i[1]]++;
        }

        int zero=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                if(zero==1){
                    return -1;
                }
                zero++;
                ans = i;
            }
        }

        return ans;
    }
}