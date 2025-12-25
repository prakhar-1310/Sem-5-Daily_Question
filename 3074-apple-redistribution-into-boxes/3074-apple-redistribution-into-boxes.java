class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i : apple){
            sum+=i;
        }

        Arrays.sort(capacity);
        int count=0;
        int j=capacity.length-1;
        while(j>=0 && sum>0){
            count++;
            sum-=capacity[j];
            j--;
        }

        return count;
    }
}