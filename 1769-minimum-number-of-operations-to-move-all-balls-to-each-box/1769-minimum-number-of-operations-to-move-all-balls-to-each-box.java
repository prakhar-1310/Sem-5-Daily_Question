class Solution {
    public int[] minOperations(String boxes) {
        int arr[] = new int[boxes.length()];
    
        int cost=0;
        int balls=0;
        
        for(int k=0;k<boxes.length();k++){
            arr[k]+=cost;
            if(boxes.charAt(k)=='1'){
                balls++;  
            }
            cost+=balls;
        }

        cost=0;
        balls=0;
        for(int i=boxes.length()-1;i>=0;i--){
            arr[i]+=cost;
            if(boxes.charAt(i)=='1'){
                balls++;
            }
            cost+=balls;
        }

        return arr;
    }
}