class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List <Integer> ll = new ArrayList<>();
        List <List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        print(0,target,candidates,ll,ans,0);
        return ans;

    }
    public static void print (int sum, int tar,int arr[],List <Integer> ll, List <List<Integer>> ans,int idx){
        if (sum == tar){
            ans.add(new ArrayList<Integer>(ll));
            return;
        }
        if (sum>tar){
            return;
        }

        for (int i =idx;i<arr.length;i++){
            if (i > idx && arr[i] == arr[i - 1]) continue;  // to overcome duplicacy
            ll.add(arr[i]);
            print (sum+arr[i],tar,arr,ll,ans,i+1);
            ll.remove(ll.size()-1);
        }
    }
}