class Solution {
    List<List<String>>ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        List<String>ll = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            ll.add(new String(row));
        }

        helper(ll,n,0,0);

        return ans;
        
    }
    
    public void helper(List<String>list,int n,int row, int qpsf){
        if(qpsf==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int col=0;col<n;col++){
            if(isitsafe(list,row,col)){
                String s = list.get(row);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(col,'Q');
                list.set(row, sb.toString());
                helper(list,n,row+1,qpsf+1);
                list.set(row,s);
            }
        }

    }

    public static boolean isitsafe(List<String>list,int row,int col){
        int r= row;

        for(int i=r;i>=0;i--){
            if(list.get(i).charAt(col)=='Q'){
                return false;
            }
        }

        r=row;
        int c = col;
        while(r>=0 && c>=0){
            if(list.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;
            c--;
        }
        
                
        


        r=row;
        c = col;
        while(r>=0 && c<list.size()){
            if(list.get(r).charAt(c)=='Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}