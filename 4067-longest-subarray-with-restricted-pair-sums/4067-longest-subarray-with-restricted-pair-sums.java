class Solution {
    public int maxSubarray(int[] nums) {

        int freq[] = new int[501];
        int n = nums.length;
        if(n<3)return n;
        for(int len=n;len>=3;len--){
            freq = new int[501];
            int left=0;
            for(int i=0;i<len;i++){
                freq[nums[i]]++;
            }

            if(helper(freq)){
                return len;
            }

            for(int right=len;right<n;right++){
                freq[nums[left]]--;
                freq[nums[right]]++;
                left++;

                if(helper(freq)){
                    return len;
                }
            }
        }

        return 2;
    }

    public boolean helper(int freq[]){
        for(int i=1;i<501;i++){
            if(freq[i]==0)continue;
            int a = i;
            if(freq[i]>1 && 2*i<501 && freq[2*i]>0)return false;
            for(int j=i+1;j<501;j++){
                if(i+j>500)break;
                if(freq[j]!=0 && freq[i+j]>0){
                    return false;
                }
            }
        }
        return true;
    }
}