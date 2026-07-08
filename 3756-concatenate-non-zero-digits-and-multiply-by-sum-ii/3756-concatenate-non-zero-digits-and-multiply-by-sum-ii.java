class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long mod = 1000000007;
        HashMap<Integer, Pair> map = new HashMap<>();
        
        long num = 0;
        long sum = 0;
        int count = 0; // FIX 1: Track the number of active digits
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long dig = ch - '0';
            if(dig != 0) {
                num = (num * 10) % mod;
                num = (num + dig) % mod;
                sum += dig;
                count++; // Increment our digit counter
            }
            // Pass the count into your Pair object
            map.put(i, new Pair(num, sum, count)); 
        }

        int arr[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            // FIX 2: Calculate pow using the tracked counts instead of String lengths
            long pow = map.get(y).count - (x == 0 ? 0 : map.get(x - 1).count);

            long currentSum = map.get(y).sum - (x == 0 ? 0 : map.get(x - 1).sum);
            
            // FIX 3: Use a custom modular exponentiation function instead of Math.pow
            long subNum = (x == 0 ? 0 : map.get(x - 1).num);
            long powerOf10 = modPow(10, pow, mod); 
            
            // FIX 4: Safely handle negative modulo results during subtraction
            long currentNum = (map.get(y).num - (subNum * powerOf10) % mod + mod) % mod;

            arr[i] = (int)((currentSum % mod * currentNum % mod) % mod);
        }

        return arr;
    }

    // Helper method required to prevent overflow when calculating 10^pow
    private long modPow(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    class Pair {
        long num;
        long sum;
        int count; // Added to track length properly

        public Pair(long num, long sum, int count){
            this.num = num;
            this.sum = sum;
            this.count = count;
        }
    }
}