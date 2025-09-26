class Solution {
    public int totalFruit(int[] arr) {
        int start=0;
        int end =0;
        int type1=-1;
        int count1=0;
        int type2 =-1;
        int count2=0;
        int ans=0;
        int type=0;
        while (end<arr.length){
            //grow
            if(arr[end]==type1 || type1==-1){
                type1=arr[end];
                count1++;
            }
            else if(arr[end]==type2 || type2==-1){
                type2=arr[end];
                count2++;
            }

            // shrink
            else{
                while (count1>0 && count2>0){
                    if (arr[start]==type1){
                        count1--;
                    }
                    else if(arr[start]==type2){
                        count2--;
                    }
                    start++;
                }
                if (count1==0){
                    type1=arr[end];
                    count1++;
                }
                else if (count2==0){
                    type2=arr[end];
                    count2++;
                }
            }
            // ans = Math.max(ans,end-start+1);
            ans = Math.max(ans,count1+count2);
            end++;
        }
        
        return ans;
    }
}