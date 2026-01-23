class Solution {
    public boolean isItPossible(String word1, String word2){
        char aa[] = new char[26];
        char bb[] = new char[26];
        for(char x : word1.toCharArray()) {
            aa[x-'a']++;
        }
        for(char x : word2.toCharArray()) {
            bb[x-'a']++;
        }
        for(int i = 0;i<26;i++) {
            if(aa[i] == 0) {
                continue;
            }
            for(int j = 0;j<26;j++) {
                if(bb[j] == 0)
                    continue;
                aa[j]++;
                aa[i]--;
                bb[i]++;
                bb[j]--;
                if(size(aa) == size(bb)) {
                    return true;
                }
                aa[j]--;
                aa[i]++;
                bb[i]--;
                bb[j]++;
            }
        }
        return false;
    }
    public int size(char aa[]) {
        int c = 0;
        for(int i = 0;i<26;i++) {
            if(aa[i] > 0) {
                c++;
            }
        }
        return c;
    } 
}