class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>list = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        list.add(newInterval);
        Collections.sort(list,(a,b)->a[0]-b[0]);
        int arr[][] = list.toArray(new int[list.size()][2]);

        list = new ArrayList<>();

        int curr[] = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=curr[1]){
                curr[1] = Math.max(curr[1],arr[i][1]);
            }

            else{
                list.add(curr);
                curr = arr[i];
            }
        }

        list.add(curr);

        return list.toArray(new int[list.size()][2]);
    }
}