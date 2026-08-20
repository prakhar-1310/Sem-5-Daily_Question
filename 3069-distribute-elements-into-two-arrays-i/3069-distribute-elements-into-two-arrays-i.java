class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer>list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(list1.get(list1.size()-1)>list2.get(list2.size()-1)){
                list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }

        int i=0;
        while(i<list1.size()){
            nums[i]=list1.get(i);
            i++;
        }
        while(i-list1.size()<list2.size()){
            nums[i]=list2.get(i-list1.size());
            i++;
        }

        return nums;
        
    }
}