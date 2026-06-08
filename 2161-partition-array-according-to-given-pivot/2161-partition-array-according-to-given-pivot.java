class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>l1 = new ArrayList<>();
        List<Integer>l2 = new ArrayList<>();
        int eqCount=0;
        for(int i : nums){
            if(i<pivot){
                l1.add(i);
            }
            else if(i>pivot){
                l2.add(i);
            }
            else{
                eqCount++;
            }
        }

        int ans[] = new int[nums.length];
        int i=0;
        for(int j:l1){
            ans[i++]=j;
        }
        for(int j=0;j<eqCount;j++){
            ans[i++]=pivot;
        }
        for(int j:l2){
            ans[i++]=j;
        }

        return ans;
    }
}