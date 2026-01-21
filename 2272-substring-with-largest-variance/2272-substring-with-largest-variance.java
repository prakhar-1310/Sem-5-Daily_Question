class Solution {
    public int largestVariance(String s) {
        
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int result = 0;

        for(char first = 'a'; first <= 'z'; first++) {
            for(char second = 'a'; second <= 'z'; second++) {

                if(first == second || count[first - 'a'] == 0 || count[second - 'a'] == 0) {
                    continue;
                }

                int firstCount = 0;
                int secondCount = 0;
                boolean pastLowFlag = false;

                for(char ch : s.toCharArray()) {
                    if(ch == first) firstCount++;
                    if(ch == second) secondCount++;

                    if(secondCount > 0) {
                        result = Math.max(result, firstCount - secondCount);
                    }
                    else{
                        if(pastLowFlag){
                            result = Math.max(result, firstCount - 1);
                        }
                    }

                    if(secondCount > firstCount) {
                        firstCount = 0;
                        secondCount = 0;
                        pastLowFlag = true;
                    }
                }
            }
        }

        return result;
    }
}