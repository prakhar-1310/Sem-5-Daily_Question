class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // HashSet <Integer> hs = new HashSet<>();
        // for (int i = 0 ; i<nums1.length;i++){
        //     for (int j=0;j<nums2.length;j++){
        //         if (nums1[i]==nums2[j]){
        //             hs.add(nums1[i]);
        //         }
        //     }
        // }
        // int arr[]= new int [ hs.size()];
        // int k =0;
        // for (int i :hs){
        //     arr[k]=i;
        //     k++;
        // }
        // return arr;


        // method2
        HashSet<Integer>set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        ArrayList<Integer>list = new ArrayList<>();

        for(int i : nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }

        int arr[] = new int [list.size()];

        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}