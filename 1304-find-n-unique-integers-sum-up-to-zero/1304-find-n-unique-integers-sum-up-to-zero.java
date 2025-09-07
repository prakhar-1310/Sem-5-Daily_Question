class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        if(n%2!=0){
            arr[n-1]=0;
        }
        int k=0;
        for(int i=0;i<n/2;i++){
            arr[k++]=-1*(i+1)*(5*n);
            arr[k++]=(i+1)*(5*n);
        }
        return arr;
    }
}