class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]>list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        Collections.sort(list, (a,b)->{
            return Double.compare(1.0*a[0]/a[1] , 1.0*b[0]/b[1]);
        });

        return list.get(k-1);
    }
}