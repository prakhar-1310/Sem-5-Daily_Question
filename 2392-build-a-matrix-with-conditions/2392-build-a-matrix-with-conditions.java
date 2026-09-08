class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int ans[][] = new int[k][k];

        List<Integer>row = helper(rowConditions, k);
        List<Integer>col = helper(colConditions, k);
        if(row.size()!=col.size() || row.size()!=k)return new int[0][0];
        for(int i =0;i<k;i++){
            Arrays.fill(ans[i], row.get(i));
        }

        for(int j=0;j<k;j++){
            int val = col.get(j);
            for(int i=0;i<k;i++){
                if(val==ans[i][j]){
                    continue;
                }
                else{
                    ans[i][j]=0;
                }
            }
        }

        return ans;
    }

    public List<Integer> helper(int arr[][], int k){
        List<Integer>list = new ArrayList<>();

        int in[] = new int[k+1];
        for(int i[] : arr){
            in[i[1]]++;
        }

        Queue<Integer>q= new LinkedList<>();
        for(int i=1;i<=k;i++){
            if(in[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int rm = q.poll();
            list.add(rm);

            for(int i[] : arr){
                if(i[0]==rm){
                    in[i[1]]--;
                    if(in[i[1]]==0){
                        q.add(i[1]);
                    }
                }
            }
        }

        return list;
    }
}