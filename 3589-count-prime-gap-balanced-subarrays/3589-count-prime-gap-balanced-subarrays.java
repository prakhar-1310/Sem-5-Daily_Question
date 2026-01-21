class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int st = 0;
        int end = 0;
        int ans = 0;
        int prime = 0;

        int lastPrimePos = -1;
        int secondLastPrimePos = -1;

        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        while (st < n) {
            int num = nums[st];

            if (isPrime(num)) {
                prime++;
                secondLastPrimePos = lastPrimePos;
                lastPrimePos = st;

                while (!min.isEmpty() && min.peekLast() > num)
                    min.pollLast();
                min.addLast(num);

                while (!max.isEmpty() && max.peekLast() < num)
                    max.pollLast();
                max.addLast(num);
            }

            while (!min.isEmpty() && !max.isEmpty()
                    && max.peekFirst() - min.peekFirst() > k) {

                if (nums[end] == min.peekFirst()) min.pollFirst();
                if (nums[end] == max.peekFirst()) max.pollFirst();
                if (isPrime(nums[end])) prime--;
                end++;
            }

            if (prime >= 2) {
                ans += Math.max(0, secondLastPrimePos - end + 1);
            }

            st++;
        }
        return ans;
    }

    public boolean isPrime(int el) {
        if (el <= 1) return false;
        for (int i = 2; i * i <= el; i++) {
            if (el % i == 0) return false;
        }
        return true;
    }
}