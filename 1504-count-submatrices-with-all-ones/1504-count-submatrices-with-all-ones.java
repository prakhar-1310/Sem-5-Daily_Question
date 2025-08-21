class Solution {
    public int numSubmat(int[][] mat) {
        int ans=0;
        for(int sr=0;sr<mat.length;sr++){
            int arr[] = new int[mat[0].length];
            for(int i=0;i<arr.length;i++){
                arr[i]=1;
            }
            for(int er=sr;er<mat.length;er++){
                for(int j=0;j<mat[0].length;j++){
                    arr[j]=arr[j]&mat[er][j];
                }
                int count=0;
                for(int k : arr){
                    if(k==1){
                        count++;
                        ans+=count;
                    }
                    else{
                        count=0;
                    }
                }
                
            }
            
        }
        return ans;
    }
}