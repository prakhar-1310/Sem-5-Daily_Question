class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                sum+=nums[i];
            }
            else{
                break;
            }
        }

        for(int i=sum; ; i++){
            if(!set.contains(i)){
                return i;
            }
        }

    }
}