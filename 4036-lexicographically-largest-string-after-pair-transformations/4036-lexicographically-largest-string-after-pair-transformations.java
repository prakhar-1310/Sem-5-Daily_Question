class Solution {
    public String[] largestString(int[] nums) {
        String ans[] = new String[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int n= nums[i];
            StringBuilder sb = new StringBuilder();
            int cnt=0;
            while(n>1 && cnt<25){
                if(n%2!=0){
                    sb.append((char)('a'+cnt));
                }
                n/=2;
                cnt++;
            }
            for(int j=0;j<n;j++){
                sb.append((char)('a'+cnt));
            }
            
            ans[i]=sb.reverse().toString();
        }

        return ans;
    }
}