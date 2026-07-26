class Solution {
    public int maxProduct(int n) {
        int len = (n+"").length();
        int arr[] = new int[len];
        for(int i=0;i<len;i++){
            int dig = n%10;
            n/=10;
            arr[i]=dig;
        }

        Arrays.sort(arr);

        return arr[len-1]*arr[len-2];
    }
}