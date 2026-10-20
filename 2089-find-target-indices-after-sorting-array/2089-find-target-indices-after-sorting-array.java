class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // List <Integer> list = new ArrayList<>();
        // Arrays.sort(nums);
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]==target){
        //         list.add(i);
        //     }
        // }
        // return list;


        // without sorting

        List <Integer> list = new ArrayList<>();
        int smaller=0;
        int larger=0;
        for (int i :nums){
            if (i<target){
                smaller++;
            }
            else if (i>target){
                larger++;
            }
        }
        // 0 1 2 3 3 3 5 6 
        //target =3;
        // smaller = 3;
        // larger = 2;
        // target starting index = smaller=3
        // target ending index = 8-1-larger=5
        for (int i=smaller;i<=nums.length-1-larger;i++){
            list.add(i);
        }
        return list;
    }
}