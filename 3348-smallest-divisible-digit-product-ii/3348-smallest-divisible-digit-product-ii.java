class Solution {

    public String smallestNumber(String num, long t) {
        long remainingFactor = t;
        for (int factor = 2; factor <= 9; factor++) {
            while (remainingFactor % factor == 0) {
                remainingFactor /= factor;
            }
        }

        if (remainingFactor > 1) {
            return "-1";
        }

        int len = num.length();
        long[] requiredFactor = new long[len + 1];
        requiredFactor[0] = t;

        int firstZeroIndex = len - 1;
        char[] digits = num.toCharArray();

        for (int i = 0; i < len; i++) {
            if (digits[i] == '0') {
                firstZeroIndex = i;
                break;
            }

            // Remove the common factors contributed
            // by the current digit.
            requiredFactor[i + 1] =requiredFactor[i] / gcd(requiredFactor[i], digits[i] - '0');
        }

        if (requiredFactor[len] == 1) {
            return num;
        }

        // Try modifying digits from right to left.
        // This helps us obtain the smallest possible answer.
        for (int i = firstZeroIndex; i >= 0; i--) {

            // Try every bigger digit at current position.
            while (++digits[i] <= '9') {

                // Calculate remaining factors
                // after choosing this digit.
                long currentNeed =requiredFactor[i] /gcd(requiredFactor[i], digits[i] - '0');

                // Start filling remaining positions
                // using the largest digit first.
                int candidateDigit = 9;

                // Fill suffix greedily.
                for (int j = len - 1; j > i; j--) {

                    // Find the largest digit
                    // that divides currentNeed.
                    while (currentNeed % candidateDigit != 0) {
                        candidateDigit--;
                    }

                    // Remove those factors.
                    currentNeed /= candidateDigit;

                    // Place that digit.
                    digits[j] = (char) ('0' + candidateDigit);
                }

                // If every required factor is covered,
                // we've found the smallest valid answer.
                if (currentNeed == 1) {
                    return new String(digits);
                }
            }
        }

        // If same length answer doesn't exist,
        // we need a longer number.
        StringBuilder answer = new StringBuilder();

        long remaining = t;

        // Build the number using largest digits first.
        // (We'll reverse it later.)
        for (int digit = 9; digit >= 2; digit--) {
            while (remaining % digit == 0) {
                answer.append((char) ('0' + digit));
                remaining /= digit;
            }
        }

        // Add extra '1's if required
        // so that new number becomes longer than original.
        int extraOnes = Math.max(len + 1 - answer.length(), 0);

        while (extraOnes-- > 0) {
            answer.append('1');
        }

        // Reverse because we built digits
        // from largest to smallest.
        return answer.reverse().toString();
    }

    private long gcd(long a, long b) {

        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}