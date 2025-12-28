class Solution {
    public int findMinimumTime(List<Integer> strength, int K) {
        int n = strength.size();
        List<Integer> perm = new ArrayList<>(strength);
        Collections.sort(perm);
        int minTime = Integer.MAX_VALUE;

        do {
            int time = 0, factor = 1;
            for (int required : perm) {
                int neededTime = (required + factor - 1) / factor;
                time += neededTime;
                factor += K;
            }
            minTime = Math.min(minTime, time);
        } while (nextPermutation(perm));

        return minTime;
    }

    private boolean nextPermutation(List<Integer> nums) {
        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i) >= nums.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = nums.size() - 1;
        while (nums.get(j) <= nums.get(i)) {
            j--;
        }
        Collections.swap(nums, i, j);
        Collections.reverse(nums.subList(i + 1, nums.size()));
        return true;
    }
}