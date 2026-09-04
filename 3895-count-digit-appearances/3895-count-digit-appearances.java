class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int cnt=0;
        for(int i : nums){
            while(i>0){
                int rem = i%10;
                if(rem==digit){
                    cnt++;
                }
                i/=10;
            }
        }

        return cnt;
    }
}