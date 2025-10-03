class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int [n];
        for (int i=0;i<n;i++){
            arr[i]=i+1;
        }
        List <Integer> ll = new ArrayList<>();
        List <List<Integer>> ans = new ArrayList<>();

        print (arr,ll,ans,k,0);

        return ans;
    }
    public static void print(int arr[], List <Integer> ll,List <List<Integer>> ans,int k,int idx){
        if (ll.size()==k){
            ans.add(new ArrayList<Integer>(ll));
            return;
        }
        for (int i=idx;i<arr.length;i++){
            ll.add(arr[i]);
            print (arr,ll,ans,k,i+1);
            ll.remove(ll.size()-1);
        }
    }
}