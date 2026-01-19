class Solution {
    public int totalSteps(int[] nums) {
        int ans=0;
        Stack<int[]>st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && st.peek()[0]<nums[i]){
                count= Math.max(count+1, st.peek()[1]);
                st.pop();
            }
            ans = Math.max(ans,count);
            st.push(new int[]{nums[i], count});
        }

        return ans;
    }
}