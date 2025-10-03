class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        helper(ans,list,candidates,target,0,0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer>list, int arr[], int target, int sum, int idx){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i=idx; i<arr.length;i++){
            list.add(arr[i]);
            helper(ans,list,arr,target,sum+arr[i],i);
            list.remove(list.size()-1);
        }
    }
}