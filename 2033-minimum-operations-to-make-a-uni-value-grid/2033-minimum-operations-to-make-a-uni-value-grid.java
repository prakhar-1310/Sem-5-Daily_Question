class Solution {
    public int minOperations(int[][] grid, int x) {
        int arr[] = new int[grid.length*grid[0].length];
        int k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[k++]=grid[i][j];
            }
        }

        Arrays.sort(arr);
        int median=arr[arr.length/2];
        System.out.println(median);
        int opr=0;
        for(int i : arr){
            int diff=Math.abs(median-i);
            if(diff%x!=0){
                return -1;
            }
            opr+=(diff/x);
        }

        return opr;
        
    }
}