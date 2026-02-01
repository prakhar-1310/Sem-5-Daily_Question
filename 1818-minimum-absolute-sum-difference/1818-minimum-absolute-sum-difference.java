class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long ans = 0;
        for(int i=0;i<nums1.length;i++){
            int n1 = nums1[i];
            int n2 = nums2[i];
            long d = Math.abs(n1-n2);
            ans+=d;
        }

        int remove=0;
        int dupli[] = nums1.clone();
        Arrays.sort(dupli);

        long minSum = ans;
        int n= nums1.length;

        // Step 3: Try replacing each nums1[i]
        for (int i = 0; i < n; i++) {
            long currentDiff = Math.abs(nums1[i] - nums2[i]);
            int target = nums2[i];

            // Lower bound binary search
            int idx = lowerBound(dupli, target);

            long bestReplacementDiff = currentDiff;

            // Check closest smaller value
            if (idx > 0) {
                bestReplacementDiff = Math.min(
                    bestReplacementDiff,
                    Math.abs(dupli[idx - 1] - target)
                );
            }

            // Check closest larger value
            if (idx < n) {
                bestReplacementDiff = Math.min(
                    bestReplacementDiff,
                    Math.abs(dupli[idx] - target)
                );
            }

            // Update minimum sum
            long newSum = ans- currentDiff + bestReplacementDiff;
            minSum = Math.min(minSum, newSum);
        }

        return (int) (minSum % 1000000007);
    }

    // Lower bound: first index where arr[index] >= target
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}