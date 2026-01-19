class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> odd = new HashSet<>();
            HashSet<Integer> even = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    odd.add(nums[j]);
                } else {
                    even.add(nums[j]);
                }
                if (odd.size() == even.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}