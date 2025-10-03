class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        helper(ans,list,k,0,arr);
        return ans;
    }

    public void helper(List<List<Integer>>ans,List<Integer>list,int k,int idx,int arr[]){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            list.add(arr[i]);
            helper(ans,list,k,i+1,arr);
            list.remove(list.size()-1);
        }
    }
}