class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet <Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        while (true){
            if (!set.contains(original)){
                return original;
            }
            original*=2;
        }
    }
}