class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // int ans[] = new int[A.length];
        // for(int i=0;i<A.length;i++){
        //     int count=0;
        //     HashSet<Integer>set = new HashSet<>();
        //     for(int j=0;j<=i;j++){
        //         set.add(A[j]);
        //     }
        //     for(int j=0;j<=i;j++){
        //         if(set.contains(B[j])){
        //             count++;
        //         }
        //     }
        //     ans[i]=count;
        // }
        // return ans;

        int ans[] = new int[A.length];
        HashSet<Integer>set = new HashSet<>();
        int count=0;
        for(int i=0;i<A.length;i++){
            if(set.contains(A[i])){
                count++;
            }
            else{
                set.add(A[i]);
            }

            if(set.contains(B[i])){
                count++;
            }
            else{
                set.add(B[i]);
            }

            ans[i]=count;
        }

        return ans;
    }
}