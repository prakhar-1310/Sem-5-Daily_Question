class Solution {
    public int firstMissingPositive(int[] arr) {
        boolean flag = false;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                flag=true;
            }
            if(arr[i]<=0 || arr[i]>n){
                arr[i]=1;
            }
        }

        if(flag == false){
            return 1;
        }

        for(int i=0;i<n;i++){
            
                int idx = Math.abs(arr[i])-1;
                arr[idx] = -Math.abs(arr[idx]);
            
            
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}