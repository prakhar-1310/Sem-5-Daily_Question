class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List <int[]> list = new ArrayList<>();
        int current[] = intervals[0];
        for (int i=0;i<intervals.length;i++){
            if (current[1]>=intervals[i][0]){
                current[1] = Math.max(current[1],intervals[i][1]);
            }
            
            else{
                list.add(current);
                current=intervals[i];
            }
        }
        list.add(current);

        return list.toArray(new int[list.size()][]);
    }
}