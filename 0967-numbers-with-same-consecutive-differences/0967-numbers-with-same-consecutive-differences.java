class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<=9;i++){
            helper(i,n-1,k);
        }
        int ans[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }

        return ans;
        
    }
    List<Integer>list = new ArrayList<>();

    public void helper(int curr, int digitLeft, int k){
        int lastDig = curr%10;
        if(digitLeft==0){
            list.add(curr);
            return;
        }
        if(lastDig+k<=9){
            helper(curr*10+lastDig+k, digitLeft-1, k);
        }
        if(k!=0 && lastDig-k>=0){ // lastDig+k == lastDig-k when k==0; to avoid this duplicacy we will check k!=0 before calling for lastDig-k
            helper(curr*10+lastDig-k, digitLeft-1,k);
        }
    }
}