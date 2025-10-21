class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        int freq[]=new int[max+k+1];

        for(int i : nums){
            freq[i]++;
        }

        // commulative sum of freq array
        for(int i=1;i<freq.length;i++){
            freq[i]=freq[i-1]+freq[i];
        }

        int result=0;
        for(int i=1;i<freq.length;i++){
            if(freq[i]==0){
                continue;
            }

            int left = Math.max(0,i-k);
            int right = Math.min(i+k,max+k);

            int totalCount = freq[right]-(left==0 ? 0 : freq[left-1]);
            int targetCount = freq[i]-freq[i-1];
            int needConversion = totalCount- targetCount;
            int canConverted =  Math.min(numOperations, needConversion);
            result=Math.max(result, canConverted+targetCount);
        }

        return result;
    }
}