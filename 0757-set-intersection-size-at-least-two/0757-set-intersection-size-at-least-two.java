class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        HashSet<Integer>set = new HashSet<>();
        Arrays.sort(intervals, (a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        set.add(intervals[0][1]);
        set.add(intervals[0][1]-1);
        int prev1 = intervals[0][1];
        int prev2 = intervals[0][1]-1;
        for(int i=1;i<intervals.length;i++){
            int arr[] = intervals[i];
            if(prev1>=arr[0] && prev2>=arr[0]){
                
            }
            else if(prev1>=arr[0]){
                prev2=arr[1];
                set.add(prev2);
            }
            else if(prev2>=arr[0]){
                prev1=arr[1];
                set.add(prev1);
            }
            else{
                prev1=arr[1];
                prev2=arr[1]-1;
                set.add(prev1);
                set.add(prev2);
            }
        }

        return set.size();
    }
}