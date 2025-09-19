class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // method 1
        // PriorityQueue<Integer>q = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         int dif = Math.abs(nums[i]-nums[j]);
        //         if(q.size()==k){
        //             if(q.peek()>dif){
        //                 q.poll();
        //                 q.add(dif);
        //             }
        //         }
        //         else{
        //             q.add(dif);
        //         }
        //     }
        // }
        // return q.poll();


        // method 2
        Arrays.sort(nums);
        int arr[] = new int [nums[nums.length-1]+1];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int dif = Math.abs(nums[i]-nums[j]);
                arr[dif]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(k-arr[i]<=0){
                return i;
            }
            k-=arr[i];
        }
        return 0;
    }
}