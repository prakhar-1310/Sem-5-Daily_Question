class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length%k!=0)return false;

        int grp = nums.length/k;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i))map.put(i, 0);

            map.put(i, map.get(i)+1);
        }

        int max=0;

        for(int i : map.keySet()){
            max = Math.max(max, map.get(i));
        }

        if(max>grp)return false;

        return true;
    }
}