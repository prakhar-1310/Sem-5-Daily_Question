class Solution {
    public int numberOfPairs(int[][] points) {
        int count=0;
        int n = points.length;
        for(int i =0;i<n;i++){
            int ax = points[i][0];
            int ay = points[i][1];
            for(int j=0;j<n;j++){
                if(j==i){
                    continue;
                }
                int bx = points[j][0];
                int by = points[j][1];

                if(ax<=bx && ay>=by){
                    boolean flag=true;
                    for(int z=0;z<n;z++){
                        if(i==z || j==z){
                            continue;
                        }
                        int zx=points[z][0];
                        int zy=points[z][1];
                        if(ax<=zx && zx<=bx && by<=zy && zy<=ay){
                            flag = false;
                            break;
                        }
                        
                    }
                    if(flag){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}