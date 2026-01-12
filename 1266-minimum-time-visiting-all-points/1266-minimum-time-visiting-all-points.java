class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum=0;
        int prev[] = points[0];
        for(int i=1;i<points.length;i++){
            int max = Math.max(Math.abs(prev[0]-points[i][0]),Math.abs(prev[1]-points[i][1]));
            int min = Math.max(Math.abs(prev[0]-points[i][0]),Math.abs(prev[1]-points[i][1]));
            sum+=min+(max-min);
            prev = points[i];
        }

        return sum;
    }
}