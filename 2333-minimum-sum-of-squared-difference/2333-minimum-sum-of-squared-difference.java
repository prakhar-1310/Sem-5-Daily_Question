class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;

        Map<Long, Long> freq = new HashMap<>();
        long maxDiff = 0;
        for (int i = 0; i < n; i++) {
            long diff = Math.abs(nums1[i] - nums2[i]);
            freq.put(diff, freq.getOrDefault(diff, 0L) + 1);
            maxDiff = Math.max(maxDiff, diff);
        }

        for (long d = maxDiff; d > 0 && k > 0; d--) {
            if (!freq.containsKey(d)) continue;

            long count = freq.get(d);
            long take = Math.min(count, k); 

            freq.put(d, count - take);
            freq.put(d - 1, freq.getOrDefault(d - 1, 0L) + take);

            k -= take;

            if (freq.get(d) == 0) freq.remove(d);
        }

        long sum = 0;
        for (Map.Entry<Long, Long> entry : freq.entrySet()) {
            long val = entry.getKey();
            long cnt = entry.getValue();
            sum += val * val * cnt;
        }
        return sum;
    }
}