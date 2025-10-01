class Solution {
    public boolean canReach(int[] arr, int start) {
        // int dp[] = new int[arr.length];
        // Arrays.fill(dp,-1);
        return helper(arr,start);
    }

    public boolean helper(int arr[], int idx){
        if(idx<0 || idx>=arr.length){
            return false;
        }
        if(arr[idx]==-1){
            return false;
        }
        if(arr[idx]==0){
            return true;
        }

        

        int temp = arr[idx];
        arr[idx]=-1;
        boolean left = helper(arr,idx-temp);
        boolean right = helper(arr,idx+temp);
        arr[idx]=temp;

        return left|| right;
    }
}