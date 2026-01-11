class Solution {
    public int minLength(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        int left=0;
        int sum=0;
        HashMap<Integer,Integer>map = new HashMap<>();
    
        for(int i=0;i<nums.length;i++){

            if(!map.containsKey(nums[i])){
                sum+=nums[i];
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }

            while(sum>=k ){
                ans = Math.min(i-left+1,ans);
                if(map.get(nums[left])==1){
                    sum-=nums[left];
                }
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }

        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}