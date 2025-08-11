class Solution {
    public int[] productQueries(int n, int[][] queries) {
        String bin = Integer.toBinaryString(n);
        int k=0;
        int mod = (int)(1000000007);
        List<Integer>list = new ArrayList<>();
        for (int i=bin.length()-1;i>=0;i--){
            if(bin.charAt(i) == '1'){
                list.add((int)(Math.pow(2,k)));
            }
            k++;
        }

        
        int ans[] = new int [queries.length];
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];

            long prod =1;
            for(int j=left;j<=right;j++){
                prod=(prod*list.get(j))%mod;
            }
            ans[i]=(int)(prod);
        }
        return ans;
    }
}