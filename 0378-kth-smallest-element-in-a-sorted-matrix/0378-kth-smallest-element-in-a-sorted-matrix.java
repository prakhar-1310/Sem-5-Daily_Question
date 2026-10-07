class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer>list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(k-1);
    }
}