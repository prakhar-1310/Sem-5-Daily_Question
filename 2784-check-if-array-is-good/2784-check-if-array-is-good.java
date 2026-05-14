class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1]+1 != nums.length){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }

        List<Integer> list= new ArrayList<>(map.values());

        int count=0;
        for (int i : list){
            if (i>=2){
                count++;
            }
        }
        if (map.get(nums[nums.length-1])==2 && count==1){
            return true;
        }
        return false;

    }
}