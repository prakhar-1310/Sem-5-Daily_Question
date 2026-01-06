class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->{
            return (nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]);
        });

        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.add(new int[]{i,0});
        }

        List<List<Integer>>list = new ArrayList<>();
        while(k-->0){
            int arr[] = pq.poll();
            int n1 = nums1[arr[0]];
            int n2 = nums2[arr[1]];

            list.add(Arrays.asList(n1,n2));

            if(arr[1] + 1 < nums2.length){
                pq.add(new int[]{arr[0],arr[1]+1});
            }
        }

        

        return list;
    }
}