class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }
        
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }
        
        long left = 0, right = (long) 1e15;
        
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            
            if (canAchieve(power, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private boolean canAchieve(long[] power, int r, int k, long target) {
        int n = power.length;
        long[] add = new long[n];
        long currAdd = 0;
        long used = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > r) {
                currAdd -= add[i - r - 1];
            }
            
            if (power[i] + currAdd < target) {
                long need = target - power[i] - currAdd;
                if (need > k - used) return false;
                
                int pos = Math.min(n - 1, i + r);
                add[pos] += need;
                currAdd += need;
                used += need;
            }
        }
        
        return true;
    }
}