class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int arr[] = new int[map.size()];
        int j=0;
        for(int i : map.values()){
            arr[j++] = i;
        }

        Arrays.sort(quantity);
        

        return helper(0,arr,quantity);

    }

    public boolean helper(int j,int arr[], int quantity[]){
        if(j>=quantity.length){
            return true;
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=quantity[j]){
                arr[i]-=quantity[j];
                if(helper(j+1,arr,quantity)){
                    return true;
                }
                arr[i]+=quantity[j];
            }
        }
        return false;
    }
}