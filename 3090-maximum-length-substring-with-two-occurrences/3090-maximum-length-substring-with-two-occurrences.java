class Solution {
    public int maximumLengthSubstring(String s) {
        int arr[] = new int[26];
        int ans=0;
        int left=0;
        for(int right=0;right<s.length(); right++){
            arr[s.charAt(right)-'a']++;
            while(arr[s.charAt(right)-'a']>2){
                arr[s.charAt(left)-'a']--;
                left++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}