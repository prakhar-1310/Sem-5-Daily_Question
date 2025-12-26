class Solution {
    public int bestClosingTime(String customers) {
        // int minHour=Integer.MAX_VALUE;
        // int minpenality=Integer.MAX_VALUE;
        // for (int j=0;j<=customers.length();j++){
        //     int penality=0;
        //     for (int i=0;i<j;i++){
        //         if (customers.charAt(i)=='N'){
        //             penality++;
        //         }
        //     }
        //     for (int i=j;i<customers.length();i++){
        //         if (customers.charAt(i)=='Y'){
        //             penality++;
        //         }
        //     }
        //     if (penality<minpenality){
        //         minHour=j;
        //     }
        //     minpenality=Math.min( minpenality,penality);
        // }
        // return minHour;



        //efficient way
        int left[]=new int [customers.length()+1];
        int right[]=new int [customers.length()+1];

        left[0]=0;
        for (int i=1;i<left.length;i++){
            if(customers.charAt(i-1)=='N'){
                left[i]=left[i-1]+1;
            }
            else{
                left[i]=left[i-1];
            }
        }

        right[right.length-1]=0;
        for (int i= right.length-2;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                right[i]=right[i+1]+1;
            }
            else{
                right[i]=right[i+1];
            }
        }

        int minHour=Integer.MAX_VALUE;
        int minpenality=Integer.MAX_VALUE;
        
        for (int j=0;j<=customers.length();j++){
            int penality=0;
            penality=left[j]+right[j];
            if (penality<minpenality){
                minHour=j;
            }
            minpenality=Math.min(minpenality,penality);
        }

        return minHour;
    }
}