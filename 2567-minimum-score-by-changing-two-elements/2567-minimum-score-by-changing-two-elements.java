class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // opt1
        int low = 0;
        int high = nums[n-2]-nums[1];
        int opt1= low + high;

        // opt2
        low =0;
        high = nums[n-3]-nums[0];
        int opt2 = low + high;

        // opt3
        low =0;
        high = nums[n-1]-nums[2];
        int opt3 = low + high;


        return Math.min(opt1, Math.min(opt2, opt3));

    }

    // 25 31 65 72 74 79
    // 31 31 65 72 74 74 opt1
    // 25 31 65 72 25 25 opt2
    // 79 79 65 72 74 79 opt3
}