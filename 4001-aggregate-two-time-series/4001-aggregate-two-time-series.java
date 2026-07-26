class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>>ans = new ArrayList<>();
        int i=0;
        int j=0;
        List<Integer>list;
        while(i<series1.length && j<series2.length){
            list=new ArrayList<>();
            if(series1[i][0]<series2[j][0]){
                list.add(series1[i][0]);
                list.add(series1[i][1]+series2[j][1]);
                i++;
                ans.add(list);
            }
            else if(series1[i][0]>series2[j][0]){
                list.add(series2[j][0]);
                list.add(series2[j][1]+series1[i][1]);
                j++;
                ans.add(list);
            }
            else{
                list.add(series2[j][0]);
                list.add(series2[j][1]+series1[i][1]);
                j++;
                i++;
                ans.add(list);
            }
        }

        while(i<series1.length){
            list=new ArrayList<>();
            list.add(series1[i][0]);
            list.add(series1[i][1]);
            i++;
            ans.add(list);
        }

        while(j<series2.length){
            list=new ArrayList<>();
            list.add(series2[j][0]);
            list.add(series2[j][1]);
            j++;
            ans.add(list);
        }

        return ans;
    }
}