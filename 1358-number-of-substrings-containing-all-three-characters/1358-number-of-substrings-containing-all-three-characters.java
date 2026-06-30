class Solution {
    public int numberOfSubstrings(String s) {
        int cnt=0;
        int left=0;
        int freq[] = new int[3];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;

            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt+=s.length()-i;
                freq[s.charAt(left++)-'a']--;
            }
        }

        return cnt;
    }
}