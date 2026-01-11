class Solution {
    public int maximalRectangle(char[][] matrix) {
        int arr[] = new int[matrix[0].length];
        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    arr[j]+=1;
                }
                else{
                    arr[j]=0;
                }
            }
            maxArea = Math.max(maxArea, max(arr));
        }
        return maxArea;
        
    }
    
    public int max(int[] heights) { // same as maximum area in histogram leet 84
        Stack<Integer>st = new Stack<>(); // will store indexes of the array height

        int area =0;
        for(int i=0;i<=heights.length;i++){
            int var=0;
            if(i<heights.length){
                var = heights[i];
            }
            while(!st.isEmpty() && heights[st.peek()]>var){
                int nsr = i;
                int tbs = heights[st.pop()]; // height of the rectangle 
                if(st.isEmpty()){
                    int nsl = -1;
                    area = Math.max(area, (nsr-nsl-1)*tbs);
                    // width = nsr-nsl-1  because we have to exclude left and right
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