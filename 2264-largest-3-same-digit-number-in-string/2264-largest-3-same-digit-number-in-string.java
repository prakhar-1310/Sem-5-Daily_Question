class Solution {
    public String largestGoodInteger(String nums) {
        int ans=-1;
        for(int i=0;i<nums.length()-2;i++){
            
            
                if(nums.charAt(i)==nums.charAt(i+1) && nums.charAt(i)==nums.charAt(i+2)){
                    ans = Math.max(ans,nums.charAt(i)-'0');
                }
            
            
        }
        if(ans==-1){
            return "";
        }
        return ans+""+ans+""+ans;
    }
}