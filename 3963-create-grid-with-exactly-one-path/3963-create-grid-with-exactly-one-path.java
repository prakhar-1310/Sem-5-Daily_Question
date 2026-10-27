class Solution {
    public String[] createGrid(int m, int n) {
        String arr[] = new String[m];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m-1;i++){
            sb = new StringBuilder(".");
            for(int j=0;j<n-1;j++){
                sb.append('#');
            }
            arr[i] = sb.toString();
        }
        sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('.');
        }
        arr[m-1]=sb.toString();

        return arr;
    }
}