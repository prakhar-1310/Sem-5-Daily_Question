class Solution {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    int ax = points[i][0];
                    int ay = points[i][1];

                    int bx = points[j][0];
                    int by = points[j][1];

                    int cx = points[k][0];
                    int cy = points[k][1];

                    double curr = Math.abs(ax*(by-cy) + bx*(ay-cy) + cx*(ay-by))/2.0;

                    area = Math.max(area,curr);
                }
            }
        }
        return area;
        
    }
}