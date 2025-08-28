class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n =grid.length;
        Map<Integer, List<Integer>> dia = new HashMap<>();
        for (int i =0;i<n;i++){
            for (int j=0;j<n;j++){
                int key = i-j;
                dia.putIfAbsent(key,new ArrayList<>());
                dia.get(key).add(grid[i][j]);
            }
        }
        
        for (int key : dia.keySet()){
            if (key>=0){
                dia.get(key).sort(Collections.reverseOrder());
                
            }
            else{
                Collections.sort(dia.get(key));
                
            }
        }
        
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                grid[i][j]=dia.get(i-j).remove(0);
            }
        }
        
        return grid;
    }
}