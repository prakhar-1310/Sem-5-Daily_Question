class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> last = new HashMap<>();

        for(int i=0;i<n;i++){
            last.put(nums[i],i);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int reve = reverse(nums[i]);

            if(last.containsKey(reve)){
                int j = last.get(reve);
                if(j>i){
                    ans = Math.min(ans,j-i);
                }
            }
        }

        return ans==Integer.MAX_VALUE? -1:ans;
    }

    public int reverse(int num){
        int r =0;
        while(num>0){
            r=r*10+(num%10);
            num/=10;
        }
        return r;
    }
}