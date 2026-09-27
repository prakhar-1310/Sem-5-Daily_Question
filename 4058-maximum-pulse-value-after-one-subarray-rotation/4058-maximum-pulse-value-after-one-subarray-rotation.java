class Solution {
    public long maxValue(int[] nums) {

        // Original pulse value
        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                total += nums[i];
            else
                total -= nums[i];
        }

        long INF = Long.MAX_VALUE / 4;

        // Minimum sum odd-length subarray
        long odd = INF;

        // Minimum sum even-length subarray
        long even = INF;

        // Minimum even-length subarray found
        long minEven = INF;

        for (int i = 0; i < nums.length; i++) {

            // Alternating-sign array
            long x = (i % 2 == 0)
                    ? nums[i]
                    : -nums[i];

            long oldOdd = odd;
            long oldEven = even;

            // Start new odd-length subarray
            // OR extend an even-length subarray
            odd = Math.min(x, oldEven + x);

            // Extend odd-length subarray
            // to make it even-length
            even = oldOdd + x;

            minEven = Math.min(minEven, even);
        }

        /*
         * If minEven < 0:
         *     rotation improves answer
         *
         * If minEven >= 0:
         *     don't rotate
         */
        if (minEven < 0) {
            total -= 2 * minEven;
        }

        return total;
    }
}