class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Check if already sorted
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                break;
            }
            if (i == n - 1) {
                return 0;
            }
        }

        // Find index of 0
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }

        boolean opt1 = checker(nums, idx);

        // Reverse the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[n - 1 - i] = nums[i];
        }

        boolean opt2 = checker(arr, n - 1 - idx);

        if (!opt1 && !opt2) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        // opt1: Original array has descending cyclic order
        if (opt1) {
            int rotations1 = (idx + 1) % n;
            int rotations2 = n - 1 - idx;

            ans = Math.min(ans,
                    1 + Math.min(rotations1, rotations2));
        }

        // opt2: Reversed array has descending cyclic order,
        // so original array has ascending cyclic order
        if (opt2) {
            ans = Math.min(ans,
                    Math.min(idx, n - idx + 2));
        }

        return ans;
    }

    public boolean checker(int[] arr, int idx) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int index = (idx - i + n) % n;
            int prev = (idx - i - 1 + n) % n;

            if (arr[prev] < arr[index]) {
                return false;
            }
        }

        return true;
    }
}