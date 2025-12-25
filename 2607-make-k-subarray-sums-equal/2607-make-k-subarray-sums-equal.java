class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        long opr=0;
        boolean visited[] = new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(visited[i]){
                continue;
            }
            List<Integer>list = new ArrayList<>();

            int j=i;
            while(!visited[j]){
                list.add(arr[j]);
                visited[j]=true;
                j = (j+k)%arr.length;
            }

            Collections.sort(list);
            int median = list.get(list.size()/2);

            for(int h : list){
                opr+=Math.abs(h-median);
            }
        }

        return opr;
    }
}