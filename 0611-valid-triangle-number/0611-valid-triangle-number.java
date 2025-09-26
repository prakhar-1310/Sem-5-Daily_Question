class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            int thirdSide = i;
            int firstSide = 0;
            int secondSide = i-1;
            while(firstSide<secondSide){
                if(nums[firstSide]+nums[secondSide]>nums[thirdSide]){
                    count+=(secondSide-firstSide);
                    secondSide--;
                }
                else{
                    firstSide++;
                }
            }
        }

        return count;
    }
}