class Solution {
    public int totalSteps(int[] nums) {
        int ans=0;
        Stack<Integer>st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && st.peek()<nums[i]){
                count++;
                st.pop();
            }
            ans = Math.max(ans,count);
            st.push(nums[i]);
        }

        return ans;
    }
}