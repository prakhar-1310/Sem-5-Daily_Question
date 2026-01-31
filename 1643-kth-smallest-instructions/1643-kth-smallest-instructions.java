class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0];  // number of vertical moves needed
        int h = destination[1];  // number of horizontal moves needed
        int totalLen = v + h;    // total length of the path
        
        // StringBuilder to construct the result
        StringBuilder result = new StringBuilder();
        
        // For each position, decide whether to put 'H' or 'V'
        for (int i = 0; i < totalLen; i++) {
            // Calculate remaining positions to fill
            int remainingLen = totalLen - i - 1;
            
            if (h > 0) {  // if we can still go horizontal
                // Calculate number of combinations if we put 'H' here
                // This represents number of paths lexicographically smaller than putting 'V'
                long combinations = combination(remainingLen, v);
                
                if (combinations >= k) {
                    result.append('H');
                    h--;
                } else {
                    result.append('V');
                    v--;
                    k -= combinations;
                }
            } else {
                result.append('V');
                v--;
            }
        }
        
        return result.toString();
    }
    
    // Helper method to calculate combinations (n choose r)
    private long combination(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        
        r = Math.min(r, n - r); // optimize by using the smaller value
        long result = 1;
        
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1);
            result /= i;
        }     
        return result;
    }
}