class Solution {
    public int balancedString(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'A']++;
        }

        int left=0;
        int ans = Integer.MAX_VALUE;
        int k=s.length()/4;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']--;
            while(left<s.length() && freq['Q'-'A']<=k && freq['W'-'A']<=k && freq['E'-'A']<=k && freq['R'-'A']<=k){
                freq[s.charAt(left)-'A']++;
                ans = Math.min(ans,right-left+1);
                left++;
            }
        }
        return ans;

    }
}