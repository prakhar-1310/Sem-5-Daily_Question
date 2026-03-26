class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        HashMap<Integer,List<Long>>rowM = new HashMap<>();
        HashMap<Integer,List<Long>>colM = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<m;i++){
            colM.put(i, new ArrayList<>());
        }

        long row[] = new long[n];
        long col[] = new long[m];
        long tot=0;
        for(int i=0;i<n;i++){
            rowM.put(i,new ArrayList<>());
            for(int j=0;j<m;j++){
                long val = grid[i][j];
                if((j==0 || j==m-1) && m!=1){
                    rowM.get(i).add(val);
                }
                if(i==0 || i==m-1){
                    rowM.get(i).add(val);
                }
                if((i==0 || i== n-1) && n!=1 ){
                    colM.get(j).add(val);
                }
                if(j==0 || j==m-1 ){
                    colM.get(j).add(val);
                }
                row[i]+=val;
                col[j]+=val;
                tot+=val;
            }
        }

        boolean r = check(row, rowM, tot);
        boolean c = check(col, colM, tot);
        System.out.println(r+" "+c);
        return r||c;
    }

    public boolean check(long arr[], HashMap<Integer, List<Long>>map, long tot){
        long left=0;
        long right = tot;
        for(int i=0;i<arr.length;i++){
            left+=arr[i];
            right-=arr[i];
            if(left==right){
                return true;
            }
            else if(left>right){
                long diff = left-right;
                if(helper(diff, 0,i,map)){
                    return true;
                }
            }
            else if(left<right){
                long diff = right-left;
                if(helper(diff, i+1,arr.length-1,map)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(long val, int st, int ed, HashMap<Integer,List<Long>>map){
        for(int i=st;i<=ed;i++){
            if(map.get(i).contains(val)){
                System.out.println(val);
                return true;
            }
        }
        return false;
    }
}