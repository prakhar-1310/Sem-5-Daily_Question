class Solution {
    public int countSpecialIntegers(int[] nums) {
        int cnt=0;
        HashSet<Integer>set=new HashSet<>();
        HashSet<Integer>n=new HashSet<>();
        set.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1] && set.contains(nums[i])){
                n.add(nums[i]);
            }

            set.add(nums[i]);
        }

        return set.size()-n.size();
    }
}