class Solution {
    public int[] processQueries(int[] queries, int m) {
        int ans[] = new int[queries.length];

        List<Integer>list=new ArrayList<>();
        for(int i=1;i<=m;i++){
            list.add(i);
        }

        for(int i=0;i<queries.length;i++){
            int idx = list.indexOf(queries[i]);

            ans[i] = idx;
            
            list.remove(idx);
            list.add(0,queries[i]);
        }  

        return ans;
    }
}