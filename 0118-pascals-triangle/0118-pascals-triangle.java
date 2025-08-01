class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowB = new ArrayList<>();
		int star =1;
        for(int i =0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            int ncr = 1;
            for (int j=0;j<star;j++) {
                row.add(ncr);
                ncr = (ncr*(i-j))/(j+1);
            }
            star++;
            rowB.add(row);
        }
        return rowB;
    }
}