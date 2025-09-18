class Solution {
    public int[][] specialGrid(int n) {
        n = (int)Math.pow(2,n);
        int ans[][] = new int [n][n];
        helper(ans,0,n-1,0,n-1);
        return ans;
    }
    int count=0;
    public void helper(int arr[][], int srow, int erow, int scol, int ecol){
        if(srow==erow && scol==ecol){
            arr[srow][scol]=count;
            count++;
            return;
        }
        int midr = (erow+srow)/2; 
        int midc = (ecol+scol)/2;
        helper(arr,srow,midr,midc+1,ecol);//top right
        helper(arr,midr+1,erow,midc+1,ecol);//bottom right
        helper(arr,midr+1,erow,scol,midc);//bottom left
        helper(arr,srow,midr,scol,midc);//top left
    }
}