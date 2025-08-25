class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int p=0;
        boolean flag=true;
        int arr[] = new int [mat.length * mat[0].length];
        for(int k = 0;k<mat.length+mat[0].length-1;k++){
            ArrayList<Integer>ll = new ArrayList<>();
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(k==i+j){
                        ll.add(mat[i][j]);
                    }
                }
            }
            if(!flag){
                for(int l : ll){
                    arr[p++]=l;
                }
            }
            else{
                Collections.reverse(ll);
                for(int l : ll){
                    arr[p++]=l;
                }
            }
            flag=!flag;
        }
        return arr;
        
    }
}