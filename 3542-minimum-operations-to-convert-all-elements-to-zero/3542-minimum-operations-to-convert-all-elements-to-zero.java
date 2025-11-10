class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer>st = new Stack<>();
        int opr=0;
        for(int i : nums){
            
            while(!st.isEmpty() && i<st.peek()){
                st.pop();
            }

            if(i==0){
                continue;
            }

            if(st.isEmpty() || st.peek()<i){
                opr++;
                st.push(i);
            }
        }

        return opr;
    }
}