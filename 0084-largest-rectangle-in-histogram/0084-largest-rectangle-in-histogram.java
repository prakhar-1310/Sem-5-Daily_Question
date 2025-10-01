class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st = new Stack<>(); // will store indexes of the array height

        int area =-0;

        for(int i=0;i<=heights.length;i++){
            int var=0;
            if(i<heights.length){
                var = heights[i];
            }
            while(!st.isEmpty() && heights[st.peek()]>var){
                int nsr = i;
                int tbs = heights[st.pop()];
                if(st.isEmpty()){
                    int nsl = -1;
                    area = Math.max(area, (nsr-nsl-1)*tbs);
                }
                else{
                    int nsl = st.peek();
                    area = Math.max(area, (nsr-nsl-1)*tbs);
                }
            }
            st.push(i);
        }
        return area;
    }
}