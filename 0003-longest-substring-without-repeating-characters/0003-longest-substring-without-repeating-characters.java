class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character>list= new ArrayList();
        int left=0;
        int ans =0;
        for(int right=0;right<s.length();right++){
            while(list.contains(s.charAt(right))){
                list.remove(0);
                left++;
            }
            list.add(s.charAt(right));
            ans =Math.max(ans,right-left+1);
        }

        return ans;
    }
}