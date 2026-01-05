class Solution {
    public int minimumBuckets(String hamsters) {
        boolean arr[] = new boolean[hamsters.length()];
        int bucket=0;
        int n = hamsters.length();
        for(int i=0;i<n;i++){
            if(arr[i]){
                continue;
            }

            if(hamsters.charAt(i)=='H'){
                if(i+1<n && hamsters.charAt(i+1)=='.'){
                    arr[i+1]=true;
                    bucket++;

                    if(i+2<n && hamsters.charAt(i+2)=='H'){
                        arr[i+2]=true;
                    }
                }
                else if(i-1>=0 && hamsters.charAt(i-1)=='.'){
                    bucket++;
                    arr[i-1]=true;
                }
                else{
                    return -1;
                }
            }
        }

        return bucket;
    }
}