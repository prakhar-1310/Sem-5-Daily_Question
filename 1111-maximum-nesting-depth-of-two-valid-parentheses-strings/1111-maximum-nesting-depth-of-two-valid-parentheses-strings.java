class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int arr[] = new int[n];
        int depth=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                arr[i]=depth%2;
                depth++;
            }
            else{
                depth--;
                arr[i]=depth%2;
            }

            
        }
        return arr;

    }
}