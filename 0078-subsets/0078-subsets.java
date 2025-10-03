class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ll =new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        print (nums,ll,ans,0);
        return ans;
    }

    public static void print(int nums[],List<Integer> ll,List<List<Integer>> ans,int idx){
        if (ll.size()<=nums.length){
            ans.add(new ArrayList<Integer>(ll));
        }
        if (ll.size()>nums.length){
            return;
        }
        for (int i=idx;i<nums.length;i++){
            ll.add(nums[i]);
            print(nums,ll,ans,i+1);
            ll.remove(ll.size()-1);
        }
    }
}