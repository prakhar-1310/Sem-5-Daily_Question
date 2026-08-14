class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int ans=0;
        int left=0;
        for(int right=0;right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.get(s.charAt(right))>2){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}