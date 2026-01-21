class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];

        for(int i=0;i<nums.size();i++){
            if(nums.get(i)%2==0){
                ans[i]=-1;
                continue;
            }

            int curr=0;
            int bit=1;
            int num = nums.get(i);

            while((bit&num)>0){
                curr = num&(~bit);
                bit=bit<<1;
            }

            ans[i]=curr;
        }

        return ans;
    }
}