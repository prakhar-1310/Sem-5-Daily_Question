class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>>ans = new ArrayList<>();
        int tar = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            tar = Math.min(tar, arr[i+1]-arr[i]);
        }

        for(int i=0;i<arr.length-1;i++){
            int a = arr[i];
            int b = arr[i+1];
            if(b-a==tar){
                List<Integer>list = new ArrayList<>();
                list.add(a);
                list.add(b);
                ans.add(list);
            }
        }

        return ans;
    }
}