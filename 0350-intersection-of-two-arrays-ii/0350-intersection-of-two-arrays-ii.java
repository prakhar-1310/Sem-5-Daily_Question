class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // ArrayList <Integer> arr= new ArrayList<>();
        // for (int i= 0;i<nums1.length;i++){
        //     for (int j =0;j<nums2.length;j++){
        //         if (nums1[i]==nums2[j]){
        //             arr.add(nums1[i]);
        //             nums2[j]=-1;
        //             break;
        //         }
        //     }
        // }
        // int arr2[]= new int[arr.size()];
        // int k=0;
        // for (int i : arr){
        //     arr2[k]=i;
        //     k++;
        // }
        // return arr2;

        
        // method2
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer>list=new ArrayList<>();

        for(int i : nums2){
            if(map.containsKey(i) && map.get(i)>0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }

        int arr[] = new int [list.size()];

        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;

        
    }
}