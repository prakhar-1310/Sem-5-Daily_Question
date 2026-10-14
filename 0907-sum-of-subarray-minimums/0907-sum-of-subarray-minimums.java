class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int prev[] = new int[n]; // previous smaller element
        int next[] = new int[n]; // next smaller element
        helper1(arr, prev);
        helper2(arr, next);

        long sum=0;
        long mod = 1000000007;
        for(int i=0;i<n;i++){
            int left = i-prev[i];
            int right = next[i]-i;
            long tot = (1L * left * right)%mod;
            tot = (tot*arr[i])%mod;
            sum=(sum+tot)%mod;
        }

        return (int)sum;
    }

    public void helper1(int arr[], int prev[]){
        Stack<Integer>st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                prev[i]=-1;
            }else{
                prev[i]=st.peek();
            }

            st.push(i);
        }
    }

    public void helper2(int arr[], int next[]){
        Stack<Integer>st = new Stack<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                next[i]=n;
            }else{
                next[i]=st.peek();
            }

            st.push(i);
        }
    }
}