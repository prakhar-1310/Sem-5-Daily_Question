class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());

            map.get(nums[i]).add(i);
        }

        Arrays.sort(nums);

        int ans[]= new int[nums.length];

        List<Integer>list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<=limit){
                list.add(nums[i]);
            }
            else{
                helper(list, map, ans);
                list=new ArrayList<>();
                list.add(nums[i]);
            }
        }
        helper(list, map, ans);

        return ans;
    }

    public void helper(List<Integer>list, HashMap<Integer, List<Integer>>map, int ans[]){

        HashSet<Integer>set = new HashSet<>();
        for(int i : list){
            for(int j : map.get(i)){
                set.add(j);
            }
        }

        List<Integer>idx = new ArrayList<>(set);

        Collections.sort(idx);

        System.out.println(idx);
        System.out.println(list);

        for(int i=0;i<idx.size();i++){
            ans[idx.get(i)]=list.get(i);
        }
    }
}